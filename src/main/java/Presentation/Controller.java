package Presentation;

import BusinessLogic.ClientBLL;
import BusinessLogic.OrderBLL;
import BusinessLogic.ProductBLL;
import DataAccess.DataForTable;
import Model.Client;
import Model.Orders;
import Model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static java.sql.Types.NULL;

public class Controller {
    private View warehouseView;
    private ClientBLL clientBll;
    private ProductBLL productBll;
    private OrderBLL orderBll;

    public Controller(View warehouseView){
        this.warehouseView = warehouseView;
        this.clientBll = new ClientBLL();
        this.productBll = new ProductBLL();
        this.orderBll = new OrderBLL();
        this.warehouseView.addProducts(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                warehouseView.productsFrame();
                warehouseView.addProduct(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String productName;
                        int productQuantity;
                        int productPrice;
                        productName = warehouseView.getProductName();
                        productQuantity = Integer.valueOf(warehouseView.getProductQuantity());
                        productPrice = Integer.valueOf(warehouseView.getProductPrice());
                        Product product = new Product(productName, productQuantity, productPrice);
                        try {
                            productBll.insertProduct(product);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                warehouseView.editProduct(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int productId;
                        String productName;
                        String productQuantityString;
                        String productPriceString;
                        int productQuantity;
                        int productPrice;
                        productId = Integer.parseInt(warehouseView.getProductId());
                        productName = warehouseView.getProductName();
                        productQuantityString = warehouseView.getProductQuantity();
                        productPriceString = warehouseView.getProductPrice();
                        if(!productQuantityString.isEmpty()){
                            productQuantity = Integer.parseInt(productQuantityString);
                        }else {
                            productQuantity = NULL;
                        }
                        if(!productPriceString.isEmpty()){
                            productPrice = Integer.parseInt(productPriceString);
                        }else {
                            productPrice = NULL;
                        }
                        Product product = new Product(productId, productName, productQuantity, productPrice);
                        try {
                            productBll.updateProductById(product);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (NoSuchFieldException ex) {
                            throw new RuntimeException(ex);
                        } catch (IllegalAccessException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                warehouseView.deleteProduct(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int productId;
                        String productName;
                        int productQuantity;
                        int productPrice;
                        String productQuantityString;
                        String productPriceString;
                        productId = Integer.parseInt(warehouseView.getProductId());
                        productName = warehouseView.getProductName();
                        productQuantityString = warehouseView.getProductQuantity();
                        productPriceString = warehouseView.getProductPrice();
                        if(!productQuantityString.isEmpty()){
                            productQuantity = Integer.parseInt(productQuantityString);
                        }else {
                            productQuantity = NULL;
                        }
                        if(!productPriceString.isEmpty()){
                            productPrice = Integer.parseInt(productPriceString);
                        }else {
                            productPrice = NULL;
                        }

                        Product product = new Product(productId, productName, productQuantity, productPrice);
                        productBll.deleteProduct(product);
                    }
                });
                warehouseView.viewProducts(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DataForTable dT = productBll.getDataForTable();
                        Object[] antet= dT.getAntet();
                        Object[][] data= dT.getTable();
                        warehouseView.setTotal(data,antet);
                    }
                });
            }
        });

        this.warehouseView.addClients(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                warehouseView.clientsFrame();
                warehouseView.addClient(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //int clientId;
                        String clientName;
                        String clientAddress;
                        String clientEmail;
                        int clientAge;
                        //clientId = Integer.parseInt(warehouseView.getClientId());
                        clientName = warehouseView.getClientName();
                        clientAddress = warehouseView.getClientAddress();
                        clientEmail = warehouseView.getClientEmail();
                        clientAge = Integer.parseInt(warehouseView.getClientAge());
                        Client client = new Client(clientName, clientAddress, clientEmail, clientAge);
                        try {
                            clientBll.insertClient(client);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                warehouseView.editClient(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int clientId;
                        String clientName;
                        String clientAddress;
                        String clientEmail;
                        String clientAgeString;
                        int clientAge;
                        clientId = Integer.parseInt(warehouseView.getClientId());
                        clientName = warehouseView.getClientName();
                        clientAddress = warehouseView.getClientAddress();
                        clientEmail = warehouseView.getClientEmail();
                        clientAgeString = String.valueOf(warehouseView.getClientAge());
                        if(!clientAgeString.isEmpty()){
                            clientAge = Integer.parseInt(clientAgeString);
                        }else {
                            clientAge = NULL;
                        }
                        Client client = new Client(clientId, clientName, clientAddress, clientEmail, clientAge);
                        try {
                            clientBll.updateClientById(client);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (NoSuchFieldException ex) {
                            throw new RuntimeException(ex);
                        } catch (IllegalAccessException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                warehouseView.deleteClient(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int id;
                        String idString;
                        String clientName;
                        String clientAddress;
                        String clientEmail;
                        String clientAgeString;
                        int clientAge;
                        idString = warehouseView.getClientId();
                        if(!idString.isEmpty()){
                            id = Integer.parseInt(idString);
                        }else {
                            id = NULL;
                        }
                        clientName = warehouseView.getClientName();
                        clientAddress = warehouseView.getClientAddress();
                        clientEmail = warehouseView.getClientEmail();
                        clientAgeString = warehouseView.getClientAge();
                        if(!clientAgeString.isEmpty()){
                            clientAge = Integer.parseInt(clientAgeString);
                        }else {
                            clientAge = NULL;
                        }
                        //clientAge = Integer.parseInt(warehouseView.getClientAge());
                        Client client = new Client(id, clientName, clientAddress, clientEmail, clientAge);
                        clientBll.deleteClient(client);
                    }
                });
                warehouseView.viewClients(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DataForTable dT = clientBll.getDataForTable();
                        Object[] antet= dT.getAntet();
                        Object[][] data= dT.getTable();
                        warehouseView.setTotal(data,antet);
//                        try {
//                            clientBll.getTableData();
//                        } catch (SQLException ex) {
//                            throw new RuntimeException(ex);
//                        }
                    }
                });
            }
        });

        this.warehouseView.addOrders(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                warehouseView.ordersFrame();
                warehouseView.addOrder(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //int id;
                        int clientId;
                        int productId;
                        int productQuantity;
                        //id = Integer.parseInt(warehouseView.getOrderId());
                        clientId = Integer.parseInt(warehouseView.getOrderClientId());
                        productId = Integer.parseInt(warehouseView.getOrderProductId());
                        productQuantity = Integer.parseInt(warehouseView.getOrderProductQuantity());

//                        Object[][] data = orderBll.getDataForTable().getTable();
//                        int sum = 0;
//                        for(int i = 0; i < data.length; i++) {
//                            for (int j = 0; j < data[i].length; j++) {
//                                if (j == 3 && (int)data[i][2] == productId) {
//                                    sum += (int) data[i][j];
//                                }
//                            }
//                        }
//                        sum += productQuantity;

                        Product product = productBll.findClientById(productId);
                        int quantity = product.getQuantity();
                        if(quantity >= productQuantity) {
                            Orders order = new Orders( clientId, productId, quantity);
                            try {
                                orderBll.insert(order);
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }else{
                            throw new IllegalArgumentException("No stock!");
                        }
                    }
                });

                warehouseView.editOrder(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int id;
                        int clientId;
                        int productId;
                        int productQuantity;

                        id = Integer.parseInt(warehouseView.getOrderId());
                        clientId = Integer.parseInt(warehouseView.getOrderClientId());
                        productId = Integer.parseInt(warehouseView.getOrderProductId());
                        productQuantity = Integer.parseInt(warehouseView.getOrderProductQuantity());

                        Orders order =new Orders(clientId,productId,productQuantity);
                        try {
                            orderBll.updateOrders(order);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (NoSuchFieldException ex) {
                            throw new RuntimeException(ex);
                        } catch (IllegalAccessException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });

                warehouseView.deleteOrder(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int id;
                        int clientId;
                        int productId;
                        int productQuantity;

                        id = Integer.parseInt(warehouseView.getOrderId());
                        clientId = Integer.parseInt(warehouseView.getOrderClientId());
                        productId = Integer.parseInt(warehouseView.getOrderProductId());
                        productQuantity = Integer.parseInt(warehouseView.getOrderProductQuantity());

                        Orders order =new Orders(id,clientId,productId,productQuantity);
                        orderBll.delete(order);
                    }
                });

                warehouseView.viewOrders(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DataForTable dT = orderBll.getDataForTable();
                        Object[] antet= dT.getAntet();
                        Object[][] data= dT.getTable();
                        warehouseView.setTotal(data,antet);
                    }
                });
            }
        });
    }
}
