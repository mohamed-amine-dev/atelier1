package ma.fstt.atelier1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class DAO {
    protected Connection connection;
    protected PreparedStatement preparedStatement;
    protected ResultSet resultSet;
    protected Statement statement;
}
