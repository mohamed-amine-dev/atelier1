package ma.fstt.atelier1.util;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DatabaseConfig {
    public static DataSource dataSource;
    private DatabaseConfig() {
        MysqlDataSource db = new MysqlDataSource();
        db.setServerName("localhost");
        db.setDatabaseName("atelier1");
        db.setUser("root");
        db.setPassword("");
        db.setPort(3306);
        dataSource = db;
    }
    public static DataSource getInstDataSource() {
        if (dataSource == null) {
            new DatabaseConfig();
        }
        return dataSource;
    }
    public DataSource getDataSource(){
        return dataSource;
    }
}
