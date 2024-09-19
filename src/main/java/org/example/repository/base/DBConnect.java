package org.example.repository.base;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect implements AutoCloseable {

    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user = "myjava";
    private static final String pass = "myjava123";

    private final Connection connection;

    public DBConnect() throws SQLException {
        this.connection = DriverManager.getConnection(url, user, pass);
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
