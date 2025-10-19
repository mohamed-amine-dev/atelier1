package ma.fstt.atelier1.dao;

import ma.fstt.atelier1.entities.OrderLine;
import ma.fstt.atelier1.services.Service;
import ma.fstt.atelier1.util.DatabaseConfig;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderLineDAO extends DAO implements Service<OrderLine> {

    public OrderLineDAO() throws Exception{
        this.connection = DatabaseConfig.getInstDataSource().getConnection();
    }

    @Override
    public OrderLine getOne(long id) throws SQLException {
        OrderLine orderLine = null;
        String query = "SELECT * FROM orderlines WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                orderLine = new OrderLine();
                orderLine.setId(resultSet.getLong("id"));
                orderLine.setProductId(resultSet.getLong("productId"));
                orderLine.setOrderId(resultSet.getLong("orderId"));
                orderLine.setUnitPrice(resultSet.getDouble("unitPrice"));
                orderLine.setQuantity(resultSet.getInt("quantity"));
                orderLine.setSubTotal(resultSet.getDouble("subTotal"));
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }

        return orderLine;
    }

    @Override
    public List<OrderLine> getAll() {
        List<OrderLine> orderLines = new ArrayList<>();
        String query = "SELECT * FROM orderlines";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                OrderLine orderLine = new OrderLine();
                orderLine.setId(resultSet.getLong("id"));
                orderLine.setProductId(resultSet.getLong("productId"));
                orderLine.setOrderId(resultSet.getLong("orderId"));
                orderLine.setUnitPrice(resultSet.getDouble("unitPrice"));
                orderLine.setQuantity(resultSet.getInt("quantity"));
                orderLine.setSubTotal(resultSet.getDouble("subTotal"));
                orderLines.add(orderLine);
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

        return orderLines;
    }

    @Override
    public void add(OrderLine orderLine) {
        String query = "INSERT INTO orderlines (productId, orderId, unitPrice, quantity, subTotal) VALUES (?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, orderLine.getProductId());
            preparedStatement.setLong(2, orderLine.getOrderId());
            preparedStatement.setDouble(3, orderLine.getUnitPrice());
            preparedStatement.setInt(4, orderLine.getQuantity());
            preparedStatement.setDouble(5, orderLine.getSubTotal());
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
    public void update(OrderLine orderLine) {
        String query = "UPDATE orderlines SET productId = ?, orderId = ?, unitPrice = ?, quantity = ?, subTotal = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, orderLine.getProductId());
            preparedStatement.setLong(2, orderLine.getOrderId());
            preparedStatement.setDouble(3, orderLine.getUnitPrice());
            preparedStatement.setInt(4, orderLine.getQuantity());
            preparedStatement.setDouble(5, orderLine.getSubTotal());
            preparedStatement.setLong(6, orderLine.getId());
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
    public void delete(OrderLine orderLine) {
        String query = "DELETE FROM orderlines WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, orderLine.getId());
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

    public List<OrderLine> getLinesByOrder(long orderId) {
        List<OrderLine> orderLines = new ArrayList<>();
        String query = "SELECT * FROM orderlines WHERE orderId = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, orderId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OrderLine orderLine = new OrderLine();
                orderLine.setId(resultSet.getLong("id"));
                orderLine.setProductId(resultSet.getLong("productId"));
                orderLine.setOrderId(resultSet.getLong("orderId"));
                orderLine.setUnitPrice(resultSet.getDouble("unitPrice"));
                orderLine.setQuantity(resultSet.getInt("quantity"));
                orderLine.setSubTotal(resultSet.getDouble("subTotal"));
                orderLines.add(orderLine);
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

        return orderLines;
    }
}