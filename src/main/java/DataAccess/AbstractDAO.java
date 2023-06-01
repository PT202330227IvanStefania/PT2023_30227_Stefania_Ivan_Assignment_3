package DataAccess;

import Connection.ConnectionFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.sql.JDBCType.NULL;


public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    private final Class<T> type;


    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " = ?");
        return sb.toString();
    }


    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createFindAllQuery();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);


        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + ex.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }


    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    private String createInsertQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT ");
        sb.append("INTO schooldb.");
        sb.append(type.getSimpleName());
        sb.append(" VALUES (");
        return sb.toString();
    }

    public String insertCondition(Field field,Object value){
        String query = "";
        if (value instanceof String) {

            query = query + "  '" + value.toString() + "',";

        } else {
            query = query + value.toString() + ",";
        }
        return query;
    }
    public void insert(T t) throws SQLException{
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createInsertQuery();

        for (Field field : type.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                query = query + insertCondition(field,field.get(t));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        query = query.substring(0, query.length() - 1) + ")";
        connection = ConnectionFactory.getConnection();
        try {
            statement = connection.prepareStatement(query);
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

    }


    private String createUpdate() {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE ");
        query.append(type.getSimpleName());
        query.append(" SET ");
        return query.toString();
    }

    public T update(T t) throws IllegalAccessException, NoSuchFieldException, SQLException {
        // TODO:
        Connection connection = null;
        PreparedStatement statement = null;
        StringBuilder query = new StringBuilder(createUpdate());
        Field idField = type.getDeclaredField("id");
        idField.setAccessible(true);
        Object idValue = idField.get(t);
        try {
            int index = 1;
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(t);
                if (!field.getName().equals("id")) {
                    if ((value != NULL) && !value.toString().isEmpty()) {
                        if (value instanceof Integer) {
                            int numericValue = ((Integer) value).intValue();
                            if (numericValue == 0) {
                                continue;
                            } else {
                                query.append(field.getName()).append(" = ?");
                            }
                        } else {
                            query.append(field.getName()).append(" = ?");
                            if (index < type.getDeclaredFields().length - 1) {
                                query.append(", ");
                            }
                            index++;
                        }
                    }
                }
            }
            if (query.charAt(query.length() - 2) == ',') {
                query.deleteCharAt(query.length() - 2); // Ștergem virgula
            }
            query.append(" WHERE ").append(idField.getName()).append(" = ?");
            String updateQuery = query.toString();

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(updateQuery);
            index = 1;
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(t);

                if (!field.getName().equalsIgnoreCase("id")) {
                    if (value != NULL && !value.toString().isEmpty()) {
                        if (value instanceof Integer) {
                            int numericValue = ((Integer) value).intValue();
                            if (numericValue == 0) {
                                continue;
                            }
                        }
                        if (value instanceof Integer) {
                            statement.setInt(index, (int) value);
                        } else if (value instanceof String) {
                            statement.setString(index, (String) value);
                        } else if (value instanceof Double) {
                            statement.setDouble(index, (Double) value);
                        }
                        index++;
                    }
                }
            }
            if (idValue instanceof Integer) {
                statement.setInt(index, (int) idValue);

                statement.executeUpdate();
            }
        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return t;
    }

    private String createDeleteQuery(String field) {
        StringBuilder query = new StringBuilder();
        query.append("DELETE ");
        query.append(" FROM ");
        query.append(type.getSimpleName());
        query.append(" WHERE " + field + " = ");
        return query.toString();
    }

    public void delete(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createDeleteQuery("id");
        int id = 0;
        for (Field field : type.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getName().equals("id")) {
                try {
                    id = Integer.parseInt(field.get(t).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        query = query + id;
        connection = ConnectionFactory.getConnection();
        try {
            statement = connection.prepareStatement(query);
            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    private String createFindAllQuery() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        query.append(" * ");
        query.append(" FROM ");
        query.append(type.getSimpleName());
        query.append(";");
        return query.toString();
    }


    public DataForTable getDataForTable(List<T> dataTable) {
        Field[] fields = type.getDeclaredFields();
        Object[][] table = new Object[dataTable.size()][fields.length];
        Object[] antet = new Object[fields.length];


        for (int i = 0; i < fields.length; i++) {
            antet[i] = fields[i].getName();
        }
        try {
            for (int i = 0; i < dataTable.size(); i++) {
                for (int j = 0; j < fields.length; j++) {
                    fields[j].setAccessible(true);

                    table[i][j] = fields[j].get(dataTable.get(i));

                }
            }
        } catch (IllegalAccessException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:getDataForTable " + e.getMessage());
            return null;
        }
        DataForTable dT = new DataForTable(antet,table);
        return dT;
    }

//    public DefaultTableModel populateTable(List<T> object){
//        DefaultTableModel table = new DefaultTableModel();
//        Class<?> type = object.get(0).getClass();
//        Field[] fieldName = type.getDeclaredFields();
//        int i = fieldName.length;
//
//        for(int currentFieldName = 0; currentFieldName < i; ++currentFieldName ) {
//            Field f = fieldName[currentFieldName];
//            f.setAccessible(true);
//            table.addColumn(f.getName());
//        }
//
//        Vector<String> columnNames = new Vector();
//        for(i = 0; i < table.getColumnCount(); ++i){
//            columnNames.add(table.getColumnName(i));
//        }
//
//        table.addRow(columnNames);
//        Iterator var = object.iterator();
//        while(var.hasNext()){
//                T t = (T) var.next();
//                Vector<Object> data = new Vector();
//                Field[] var2 = type.getDeclaredFields();
//                int var3 = var2.length;
//
//                for(int var4 = 0; var4 < var3; ++var4) {
//                    Field f = var2[var4];
//                    f.setAccessible(true);
//
//                    try {
//                        Object value = f.get(t);
//                        data.add(value);
//
//                    } catch (IllegalAccessException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            table.addRow(data);
//        }
//        return table;
//    }

}




