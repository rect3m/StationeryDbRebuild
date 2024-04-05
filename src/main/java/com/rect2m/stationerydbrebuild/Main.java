package com.rect2m.stationerydbrebuild;

import com.rect2m.stationerydbrebuild.database.ConnectionPool;
import com.rect2m.stationerydbrebuild.database.DatabaseInitializer;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        Connection connection = ConnectionPool.getConnection();
        if (connection != null) {
            DatabaseInitializer.initializeDatabase(connection);
            ConnectionPool.releaseConnection(connection);
        }
    }
}