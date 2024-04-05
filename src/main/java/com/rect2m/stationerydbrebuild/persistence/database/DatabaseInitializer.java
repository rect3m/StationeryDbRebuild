package com.rect2m.stationerydbrebuild.persistence.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initializeDatabase(Connection connection) {
        try {
            createCategoriesTable(connection);
            createManufacturersTable(connection);
            createProductsTable(connection);
            createOrdersTable(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createCategoriesTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS categories (\n" +
                    "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    name VARCHAR(255) NOT NULL\n" +
                    ")");
        }
    }

    private static void createManufacturersTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS manufacturers (\n" +
                    "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    name VARCHAR(255) NOT NULL,\n" +
                    "    country VARCHAR(255) NOT NULL\n" +
                    ")");
        }
    }

    private static void createProductsTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS products (\n" +
                    "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    name VARCHAR(255) NOT NULL,\n" +
                    "    description TEXT,\n" +
                    "    price DECIMAL(10, 2) NOT NULL,\n" +
                    "    category_id INT,\n" +
                    "    manufacturer_id INT,\n" +
                    "    FOREIGN KEY (category_id) REFERENCES categories(id),\n" +
                    "    FOREIGN KEY (manufacturer_id) REFERENCES manufacturers(id)\n" +
                    ")");
        }
    }

    private static void createOrdersTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS orders (\n" +
                    "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    date DATE NOT NULL,\n" +
                    "    product_id INT,\n" +
                    "    quantity INT NOT NULL,\n" +
                    "    FOREIGN KEY (product_id) REFERENCES products(id)\n" +
                    ")");
        }
    }
}
