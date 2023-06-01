package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JFrame frame;
    private JFrame viewAllFrame;
    private JLabel t;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton buttonAddClient;
    private JButton buttonEditClient;
    private JButton buttonDeleteClient;
    private JButton buttonViewAll;

    private JButton buttonAddProduct;
    private JButton buttonEditProduct;
    private JButton buttonDeleteProduct;
    private JButton buttonViewAllProducts;

    private JButton buttonAddOrder;
    private JButton buttonEditOrder;
    private JButton buttonDeleteOrder;
    private JButton buttonViewAllOrders;

    JTextField orderIdText;
    JTextField orderProductIdText;
    JTextField orderClientIdText;
    JTextField orderProductQuantityText;
    JTextField idText;
    JTextField nameText;
    JTextField addressText;
    JTextField quantityText;
    JTextField emailText;
    JTextField ageText;

    JTextField productNameText;
    JTextField productIdText;
    JTextField productPriceText;
    private JTable tabela;


    public View(){
        frame = new JFrame("Orders Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);

        JPanel title = new JPanel();
        t = new JLabel("Orders Management");
        t.setFont(new Font("Arial", Font.BOLD, 24));
        title.add(t);
        title.setLayout(new FlowLayout());

        JPanel buttons = new JPanel();
        button1 = new JButton("Products");
        button2 = new JButton("Clients");
        button3 = new JButton("Orders");
        button1.setPreferredSize(new Dimension(200,50));
        button1.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        button2.setPreferredSize(new Dimension(200,50));
        button2.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        button3.setPreferredSize(new Dimension(200,50));
        button3.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.setLayout(new FlowLayout());

        JPanel p = new JPanel();
        p.add(title);
        p.add(buttons);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        frame.setContentPane(p);
        frame.setVisible(true);
    }

    public void addProducts(ActionListener actionListener){
        this.button1.addActionListener(actionListener);
    }

    public void addClients(ActionListener actionListener){
        this.button2.addActionListener(actionListener);
    }

    public void addOrders(ActionListener actionListener){
        this.button3.addActionListener(actionListener);
    }

    public void productsFrame(){
        JFrame productsFrame = new JFrame("Products");
        productsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        productsFrame.setSize(800,600);
//        String[] columnNames = {"productId", "productName", "productQuantity", "productPrice"};
//        Object[][] data = {};
//        JTable table = new JTable(data, columnNames);
//        JScrollPane c = new JScrollPane(table);
        JPanel buttonsProducts = new JPanel();
        buttonAddProduct = new JButton("Add Product");
        buttonEditProduct = new JButton("Edit Product");
        buttonDeleteProduct = new JButton("Delete Product");
        buttonViewAllProducts = new JButton("View All Products");
        buttonAddProduct.setPreferredSize(new Dimension(150,30));
        buttonAddProduct.setFont(new Font("Book Antiqua", Font.BOLD, 15));
        buttonEditProduct.setPreferredSize(new Dimension(150,30));
        buttonEditProduct.setFont(new Font("Book Antiqua", Font.BOLD, 15));
        buttonDeleteProduct.setPreferredSize(new Dimension(150,30));
        buttonDeleteProduct.setFont(new Font("Book Antiqua", Font.BOLD, 15));
        buttonViewAllProducts.setPreferredSize(new Dimension(150,30));
        buttonViewAllProducts.setFont(new Font("Book Antiqua", Font.BOLD, 15));
        buttonsProducts.add(buttonAddProduct);
        buttonsProducts.add(buttonEditProduct);
        buttonsProducts.add(buttonDeleteProduct);
        buttonsProducts.add(buttonViewAllProducts);
        buttonsProducts.setLayout(new FlowLayout());
        JPanel l = new JPanel();
        JLabel productId = new JLabel("Product ID: ");
        productIdText = new JTextField(2);
        JLabel productName = new JLabel("Product Name: ");
        productNameText = new JTextField(20);
        JLabel productQuantity = new JLabel("Product Quantity: ");
        quantityText = new JTextField(20);
        l.add(productId);
        l.add(productIdText);
        l.add(productName);
        l.add(productNameText);
        l.add(productQuantity);
        l.add(quantityText);

        JPanel l2 = new JPanel();
        JLabel price = new JLabel("Product Price: ");
        productPriceText = new JTextField(5);
        l2.add(price);
        l2.add(productPriceText);
        l2.setLayout(new FlowLayout());
        JPanel p = new JPanel();
        p.add(l);
        p.add(l2);
        p.add(buttonsProducts);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        productsFrame.setContentPane(p);
        productsFrame.setVisible(true);
    }


    public void clientsFrame(){
        JFrame clientsFrame = new JFrame("Clients");
        clientsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        clientsFrame.setSize(800,600);
        JPanel buttonsClients = new JPanel();
        buttonAddClient = new JButton("Add Client");
        buttonEditClient = new JButton("Edit Client");
        buttonDeleteClient = new JButton("Delete Client");
        buttonViewAll = new JButton("View All");
        buttonAddClient.setPreferredSize(new Dimension(150,30));
        buttonAddClient.setFont(new Font("Book Antiqua", Font.BOLD, 15));
        buttonEditClient.setPreferredSize(new Dimension(150,30));
        buttonEditClient.setFont(new Font("Book Antiqua", Font.BOLD, 15));
        buttonDeleteClient.setPreferredSize(new Dimension(150,30));
        buttonDeleteClient.setFont(new Font("Book Antiqua", Font.BOLD, 15));
        buttonViewAll.setPreferredSize(new Dimension(150,30));
        buttonViewAll.setFont(new Font("Book Antiqua", Font.BOLD, 15));
        buttonsClients.add(buttonAddClient);
        buttonsClients.add(buttonEditClient);
        buttonsClients.add(buttonDeleteClient);
        buttonsClients.add(buttonViewAll);
        buttonsClients.setLayout(new FlowLayout());
        JPanel l = new JPanel();
        JLabel id = new JLabel("Client ID: ");
        idText = new JTextField(2);
        JLabel name = new JLabel("Client Name: ");
        nameText = new JTextField(20);
        JLabel address = new JLabel("Client Address: ");
        addressText = new JTextField(20);
        l.add(id);
        l.add(idText);
        l.add(name);
        l.add(nameText);
        l.add(address);
        l.add(addressText);

        JPanel l2 = new JPanel();
        JLabel email = new JLabel("Client Email: ");
        emailText = new JTextField(20);
        JLabel age = new JLabel("Client Age: ");
        ageText = new JTextField(5);
        l2.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 85));
        l2.add(email);
        l2.add(emailText);
        l2.add(age);
        l2.add(ageText);
        l2.setLayout(new FlowLayout());
        JPanel p = new JPanel();
        p.add(l);
        p.add(l2);
        p.add(buttonsClients);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        clientsFrame.setContentPane(p);
        clientsFrame.setVisible(true);
    }

    public void ordersFrame(){
        JFrame ordersFrame = new JFrame("Orders");
        ordersFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ordersFrame.setSize(800,600);
        JPanel buttonsOrders = new JPanel();
        buttonAddOrder = new JButton("Add Order");
        buttonEditOrder = new JButton("Edit Order");
        buttonDeleteOrder = new JButton("Delete Order");
        buttonViewAllOrders = new JButton("View All Orders");
        buttonAddOrder.setPreferredSize(new Dimension(150,30));
        buttonAddOrder.setFont(new Font("Book Antiqua", Font.BOLD, 15));
        buttonEditOrder.setPreferredSize(new Dimension(150,30));
        buttonEditOrder.setFont(new Font("Book Antiqua", Font.BOLD, 15));
        buttonDeleteOrder.setPreferredSize(new Dimension(150,30));
        buttonDeleteOrder.setFont(new Font("Book Antiqua", Font.BOLD, 15));
        buttonViewAllOrders.setPreferredSize(new Dimension(150,30));
        buttonViewAllOrders.setFont(new Font("Book Antiqua", Font.BOLD, 15));
        buttonsOrders.add(buttonAddOrder);
        buttonsOrders.add(buttonEditOrder);
        buttonsOrders.add(buttonDeleteOrder);
        buttonsOrders.add(buttonViewAllOrders);
        buttonsOrders.setLayout(new FlowLayout());

        JPanel l = new JPanel();
        JLabel orderId = new JLabel("Order ID: ");
        orderIdText = new JTextField(2);
        JLabel productId = new JLabel("Product Id: ");
        orderProductIdText = new JTextField(20);
        JLabel clientId = new JLabel("Client Id: ");
        orderClientIdText = new JTextField(20);
        l.add(orderId);
        l.add(orderIdText);
        l.add(productId);
        l.add(orderProductIdText);
        l.add(clientId);
        l.add(orderClientIdText);

        JPanel l2 = new JPanel();
        JLabel productQuantity = new JLabel("Product Quantity: ");
        orderProductQuantityText = new JTextField(20);
        l2.add(productQuantity);
        l2.add(orderProductQuantityText);
        l2.setLayout(new FlowLayout());
        JPanel p = new JPanel();
        p.add(l);
        p.add(l2);
        p.add(buttonsOrders);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        ordersFrame.setContentPane(p);

        ordersFrame.setVisible(true);
    }

    public void addClient(ActionListener actionListener){
        this.buttonAddClient.addActionListener(actionListener);
    }
    public void editClient(ActionListener actionListener){
        this.buttonEditClient.addActionListener(actionListener);
    }
    public void deleteClient(ActionListener actionListener){
        this.buttonDeleteClient.addActionListener(actionListener);
    }

    public void viewClients(ActionListener actionListener){
        this.buttonViewAll.addActionListener(actionListener);
    }

    public void addProduct(ActionListener actionListener){
        this.buttonAddProduct.addActionListener(actionListener);
    }
    public void editProduct(ActionListener actionListener){
        this.buttonEditProduct.addActionListener(actionListener);
    }
    public void deleteProduct(ActionListener actionListener){
        this.buttonDeleteProduct.addActionListener(actionListener);
    }

    public void viewProducts(ActionListener actionListener){
        this.buttonViewAllProducts.addActionListener(actionListener);
    }

    public void addOrder(ActionListener actionListener){
        this.buttonAddOrder.addActionListener(actionListener);
    }
    public void editOrder(ActionListener actionListener){
        this.buttonEditOrder.addActionListener(actionListener);
    }
    public void deleteOrder(ActionListener actionListener){
        this.buttonDeleteOrder.addActionListener(actionListener);
    }

    public void viewOrders(ActionListener actionListener){
        this.buttonViewAllOrders.addActionListener(actionListener);
    }

    public void setTotal(Object[][] data, Object[] column) {
        viewAllFrame = new JFrame();
        viewAllFrame.setTitle("ViewAll");
        viewAllFrame.setSize(800,800);
        tabela = new JTable(data, column);
        JScrollPane sp = new JScrollPane(tabela);
        viewAllFrame.add(sp);

        viewAllFrame.setSize(500, 200);
        viewAllFrame.setVisible(true);
    }

    public String getClientId(){
        return this.idText.getText();
    }

    public String getClientName(){
        return this.nameText.getText();
    }

    public String getClientAddress(){
        return this.addressText.getText();
    }

    public String getClientEmail(){
        return this.emailText.getText();
    }

    public String getClientAge(){
        return this.ageText.getText();
    }


    public String getProductId(){
        return this.productIdText.getText();
    }

    public String getProductName(){
        return this.productNameText.getText();
    }

    public String getProductQuantity(){
        return this.quantityText.getText();
    }

    public String getProductPrice(){
        return this.productPriceText.getText();
    }

    public String getOrderId(){
        return this.orderIdText.getText();
    }

    public String getOrderProductId(){
        return this.orderProductIdText.getText();
    }

    public String getOrderClientId(){
        return this.orderClientIdText.getText();
    }

    public String getOrderProductQuantity(){
        return this.orderProductQuantityText.getText();
    }


}
