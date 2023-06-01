package BusinessLogic;

import DataAccess.DataForTable;
import DataAccess.ProductDAO;
import Model.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductBLL {
    private ProductDAO productDAO;

    public ProductBLL() {
        this.productDAO = new ProductDAO();
    }

    public Product findClientById(int id) {
        Product st = productDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return st;
    }

    public void deleteProduct(Product product){
        productDAO.delete(product);
    }
    public Product findProductById(int id) {
        Product pr = productDAO.findById(id);
        if (pr == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return pr;
    }

    public void updateProductById(Product product) throws SQLException, NoSuchFieldException, IllegalAccessException {

        productDAO.update(product);
    }

    public void insertProduct(Product product) throws SQLException {

        productDAO.insert(product);
    }

    public List<Product> viewAll(){
        return productDAO.findAll();
    }

    public DataForTable getDataForTable(){
        return productDAO.getDataForTable(productDAO.findAll());
    }
}
