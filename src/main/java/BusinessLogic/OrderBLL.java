package BusinessLogic;

import DataAccess.DataForTable;
import DataAccess.OrderDAO;
import Model.Orders;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

public class OrderBLL {
    private OrderDAO orderDAO;

    public OrderBLL(){
        this.orderDAO = new OrderDAO();
    }

    public Orders findClientById(int id){
        Orders o = orderDAO.findById(id);
        if(o == null){
            throw new NoSuchElementException("The order with id =" + id + " was not found!");
        }
        return o;
    }

    public void updateOrders(Orders o) throws SQLException, NoSuchFieldException, IllegalAccessException {

        orderDAO.update(o);
    }

    public void insert(Orders o) throws SQLException {
        orderDAO.insert(o);
    }

    public void delete(Orders o){
        orderDAO.delete(o);
    }

    public List<Orders> viewAll(){
        return orderDAO.findAll();
    }

    public DataForTable getDataForTable(){
        return orderDAO.getDataForTable(orderDAO.findAll());
    }

}
