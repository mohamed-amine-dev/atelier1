package ma.fstt.atelier1.dao;

import ma.fstt.atelier1.services.Service;
import ma.fstt.atelier1.util.DatabaseConfig;

import java.sql.SQLException;
import java.util.List;

public class ClientDAO extends DAO implements Service  {


public ClientDAO() throws SQLException {
    connection = DatabaseConfig.getInstDataSource().getConnection();
}



    @Override
    public Object getClient() {
        return null;
    }

    @Override
    public List getAllClients() {
        return List.of();
    }

    @Override
    public void addClient(Object newClient) {

    }

    @Override
    public void updateClient(Object newClient) {

    }

    @Override
    public void deleteClient(Object newClient) {

    }
}
