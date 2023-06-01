//package DataAccess;
//
//import Connection.ConnectionFactory;
//import Model.Student;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class StudentDAO {
//    protected static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
//    private static final String insertStatementString = "INSERT INTO student (name,address,email,age)"
//            + " VALUES (?,?,?,?)";
//    private final static String findStatementString = "SELECT * FROM student where id = ?";
//    //private final static String editStatementString = "UPDATE student SET name = ?, address = ?, email = ?, age = ? WHERE id = ?";
//    private final static StringBuilder editStatementString = new StringBuilder("UPDATE student SET");
//    private final static StringBuilder deleteStatementString = new StringBuilder("DELETE from student WHERE ");
//
//    public static Student delete(String condition){
//        Connection dbConnection = ConnectionFactory.getConnection();
//        PreparedStatement deleteStatement = null;
//        deleteStatementString.append(condition);
//        try{
//            deleteStatement = dbConnection.prepareStatement(String.valueOf(deleteStatementString));
//            deleteStatement.executeUpdate();
//        } catch (SQLException e) {
//            LOGGER.log(Level.WARNING,"StudentDAO:delete " + e.getMessage());
//        }finally {
//            ConnectionFactory.close(deleteStatement);
//            ConnectionFactory.close(dbConnection);
//        }
//        return null;
//    }
//
//    public static Student updateById(int studentId, String studentName, String studentAddress, String studentEmail, int studentAge){
//        Student toReturn = null;
//        Connection dbConnection = ConnectionFactory.getConnection();
//        PreparedStatement editStatement = null;
//        PreparedStatement findStatement = null;
//        ArrayList<Object> params = new ArrayList<>();
//
//        if(studentName != null){
//            editStatementString.append(" name = ?,");
//            params.add(studentName);
//        }
//
//        if(studentAddress != null){
//            editStatementString.append(" address = ?,");
//            params.add(studentAddress);
//        }
//
//        if(studentEmail != null){
//            editStatementString.append(" email = ?,");
//            params.add(studentEmail);
//        }
//
//        if(studentAge != 0){
//            editStatementString.append(" age = ?,");
//            params.add(studentAge);
//        }
//
//        editStatementString.deleteCharAt(editStatementString.length() - 1);
//        editStatementString.append(" WHERE id = ?");
//        params.add(studentId);
//
//        try{
//            editStatement = dbConnection.prepareStatement(String.valueOf(editStatementString), Statement.RETURN_GENERATED_KEYS);
////            editStatement.setString(1, studentName);
////            editStatement.setString(2, studentAddress);
////            editStatement.setString(3, studentEmail);
////            editStatement.setLong(4, studentAge);
////            editStatement.setLong(5, studentId);
//            for(int i = 0; i < params.size(); i++){
//                Object param = params.get(i);
//                editStatement.setObject(i+1, param);
//            }
//            editStatement.executeUpdate();
//            findStatement = dbConnection.prepareStatement(findStatementString);
//            findStatement.setLong(1, studentId);
//            ResultSet rs = findStatement.executeQuery();
//            if(rs.next()) {
//                String name = rs.getString("name");
//                String address = rs.getString("address");
//                String email = rs.getString("email");
//                int age = rs.getInt("age");
//                toReturn = new Student(studentId, name, address, email, age);
//            }
//        } catch (SQLException e) {
//            LOGGER.log(Level.WARNING,"StudentDAO:editById " + e.getMessage());
//        } finally{
//            ConnectionFactory.close(editStatement);
//            ConnectionFactory.close(dbConnection);
//        }
//        return toReturn;
//    }
//    public static Student findById(int studentId) {
//        Student toReturn = null;
//
//        Connection dbConnection = ConnectionFactory.getConnection();
//        PreparedStatement findStatement = null;
//        ResultSet rs = null;
//        try {
//            findStatement = dbConnection.prepareStatement(findStatementString);
//            findStatement.setLong(1, studentId);
//            rs = findStatement.executeQuery();
//            rs.next();
//
//            String name = rs.getString("name");
//            String address = rs.getString("address");
//            String email = rs.getString("email");
//            int age = rs.getInt("age");
//            toReturn = new Student(studentId, name, address, email, age);
//        } catch (SQLException e) {
//            LOGGER.log(Level.WARNING,"StudentDAO:findById " + e.getMessage());
//        } finally {
//            ConnectionFactory.close(rs);
//            ConnectionFactory.close(findStatement);
//            ConnectionFactory.close(dbConnection);
//        }
//        return toReturn;
//    }
//
//    public static int insert(Student student) {
//        Connection dbConnection = ConnectionFactory.getConnection();
//
//        PreparedStatement insertStatement = null;
//        int insertedId = -1;
//        try {
//            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
//            insertStatement.setString(1, student.getName());
//            insertStatement.setString(2, student.getAddress());
//            insertStatement.setString(3, student.getEmail());
//            insertStatement.setInt(4, student.getAge());
//            insertStatement.executeUpdate();
//
//            ResultSet rs = insertStatement.getGeneratedKeys();
//            if (rs.next()) {
//                insertedId = rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            LOGGER.log(Level.WARNING, "StudentDAO:insert " + e.getMessage());
//        } finally {
//            ConnectionFactory.close(insertStatement);
//            ConnectionFactory.close(dbConnection);
//        }
//        return insertedId;
//    }
//
//}
