package Model;

public class Product {
    private int id;
    private String productName;
    private int productQuantity;
    private int productPrice;

    public Product(int id, String productName, int productQuantity, int productPrice){
        this.id = id;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public Product(String productName, int productQuantity, int productPrice){
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return productQuantity;
    }

    public void setQuantity(int quantity) {
        this.productQuantity = quantity;
    }

    public String getName() {
        return productName;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String toString() {
        return "Product [id=" + id + ", name=" + productName + ", quantity=" + productQuantity + ", price=" + productPrice + "]";
    }
}
