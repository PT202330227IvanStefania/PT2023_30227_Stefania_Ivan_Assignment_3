package BusinessLogic;

import BusinessLogic.Validators.ClientAgeValidator;
import BusinessLogic.Validators.ClientEmailValidator;
import BusinessLogic.Validators.Validator;
import DataAccess.ClientDAO;
import DataAccess.DataForTable;
import Model.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ClientBLL {
    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new ClientEmailValidator());
        validators.add(new ClientAgeValidator());
        this.clientDAO = new ClientDAO();
    }

    public void deleteClient(Client client){
        clientDAO.delete(client);
    }
    public Client findClientById(int id) {
        Client st = clientDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return st;
    }

    public void updateClientById(Client client) throws SQLException, NoSuchFieldException, IllegalAccessException {

        clientDAO.update(client);
    }

    public void insertClient(Client client) throws SQLException {
        for (Validator<Client> v : validators) {
            v.validate(client);
        }
        clientDAO.insert(client);
    }

    public List<Client> findAll() throws SQLException {
        return clientDAO.findAll();
    }

    public DataForTable getDataForTable(){
        return clientDAO.getDataForTable(clientDAO.findAll());
    }

//    public DefaultTableModel getTableData() throws SQLException {
//        DefaultTableModel data = this.clientDAO.populateTable(this.findAll());
//        if(data == null){
//            throw new NoSuchElementException("There are no clients!");
//        }else{
//            return data;
//        }
//    }

}
