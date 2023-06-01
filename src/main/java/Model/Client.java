package Model;

public class Client {
    private int id;
    private String clientName;
    private String clientAddress;
    private String clientEmail;
    private int clientAge;
    public Client(int clientId, String clientName, String clientAddress, String clientEmail, int clientAge) {
        this.id = clientId;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientEmail = clientEmail;
        this.clientAge = clientAge;
    }

    public Client( String clientName, String clientAddress, String clientEmail, int clientAge) {
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientEmail = clientEmail;
        this.clientAge = clientAge;
    }

    public int getClientAge() {
        return clientAge;
    }

    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientId() {
        return id;
    }

    public void setClientId(int clientId) {
        this.id = clientId;
    }

    public String toString() {
        return "Client [id=" + id + ", name=" + clientName + ", address=" + clientAddress + ", email=" + clientEmail + ", age=" + clientAge
                + "]";
    }

}
