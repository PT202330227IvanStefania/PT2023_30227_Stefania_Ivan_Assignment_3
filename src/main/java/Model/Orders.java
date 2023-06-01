package Model;

public class Orders {
    private int id;
    private int clientId;
    private int productId;
    private int productQuantity;

    public Orders(int orderId, int clientId, int productId, int productQuantity){
        this.id = orderId;
        this.clientId = clientId;
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public Orders( int clientId, int productId, int productQuantity){
        this.clientId = clientId;
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Order [id=" + id + ", clientId=" + clientId + ", productId=" + productId + ", productQuantity=" + productQuantity + "]";
    }
}
