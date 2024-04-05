package com.rect2m.stationerydbrebuild.persistence.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static final String URL = "jdbc:h2:./data/stationery";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    private static final int MAX_CONNECTIONS = 10;
    private static final List<Connection> availableConnections = new ArrayList<>();
    private static final List<Connection> usedConnections = new ArrayList<>();

    static {
        try {
            for (int i = 0; i < MAX_CONNECTIONS; i++) {
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                availableConnections.add(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Connection getConnection() {
        if (availableConnections.isEmpty()) {
            System.err.println("All connections are in use.");
            return null;
        }

        Connection connection = availableConnections.remove(availableConnections.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public static synchronized void releaseConnection(Connection connection) {
        if (connection != null && usedConnections.remove(connection)) {
            availableConnections.add(connection);
        }
    }
}
