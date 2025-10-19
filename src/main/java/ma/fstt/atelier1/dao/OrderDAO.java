package ma.fstt.atelier1.dao;

import ma.fstt.atelier1.entities.Order;
import ma.fstt.atelier1.services.Service;
import ma.fstt.atelier1.util.DatabaseConfig;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends DAO implements Service<Order> {

    public OrderDAO() throws Exception{
        this.connection = DatabaseConfig.getInstDataSource().getConnection();
    }

    @Override
    public Order getOne(long id) throws SQLException {
        Order order = null;
        String query = "SELECT * FROM orders WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                order = new Order();
                order.setId(resultSet.getLong("id"));
                order.setClientId(resultSet.getLong("clientId"));
                order.setDateCommand(resultSet.getTimestamp("dateCommand").toLocalDateTime());
                order.setTotalAmount(resultSet.getDouble("totalAmount"));
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }

        return order;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getLong("id"));
                order.setClientId(resultSet.getLong("clientId"));
                order.setDateCommand(resultSet.getTimestamp("dateCommand").toLocalDateTime());
                order.setTotalAmount(resultSet.getDouble("totalAmount"));
                orders.add(order);
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

        return orders;
    }

    @Override
    public void add(Order order) {
        String query = "INSERT INTO orders (clientId, dateCommand, totalAmount) VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, order.getClientId());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(order.getDateCommand()));
            preparedStatement.setDouble(3, order.getTotalAmount());
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
    public void update(Order order) {
        String query = "UPDATE orders SET clientId = ?, dateCommand = ?, totalAmount = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, order.getClientId());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(order.getDateCommand()));
            preparedStatement.setDouble(3, order.getTotalAmount());
            preparedStatement.setLong(4, order.getId());
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
    public void delete(Order order) {
        String query = "DELETE FROM orders WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, order.getId());
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

    public List<Order> getOrdersByClient(long clientId) {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders WHERE clientId = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, clientId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getLong("id"));
                order.setClientId(resultSet.getLong("clientId"));
                order.setDateCommand(resultSet.getTimestamp("dateCommand").toLocalDateTime());
                order.setTotalAmount(resultSet.getDouble("totalAmount"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return orders;
    }
}
