package ma.fstt.atelier1.dao;

import ma.fstt.atelier1.entities.Client;
import ma.fstt.atelier1.services.Service;
import ma.fstt.atelier1.util.DatabaseConfig;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends DAO implements Service<Client> {

    public ClientDAO() throws Exception{
        this.connection = DatabaseConfig.getInstDataSource().getConnection();
    }

    @Override
    public Client getOne(long id) throws SQLException {
        Client client = null;
        String query = "SELECT * FROM clients WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                client = new Client();
                client.setId(resultSet.getLong("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setAdress(resultSet.getString("adress"));
                client.setPhoneNumber(resultSet.getString("phoneNumber"));
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }

        return client;
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM clients";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getLong("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setAdress(resultSet.getString("adress"));
                client.setPhoneNumber(resultSet.getString("phoneNumber"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return clients;
    }

    @Override
    public void add(Client newClient) {
        String query = "INSERT INTO clients (name, email, adress, phoneNumber) VALUES (?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newClient.getName());
            preparedStatement.setString(2, newClient.getEmail());
            preparedStatement.setString(3, newClient.getAdress());
            preparedStatement.setString(4, newClient.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Client client) {
        String query = "UPDATE clients SET name = ?, email = ?, adress = ?, phoneNumber = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setString(3, client.getAdress());
            preparedStatement.setString(4, client.getPhoneNumber());
            preparedStatement.setLong(5, client.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Client client) {
        String query = "DELETE FROM clients WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, client.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}