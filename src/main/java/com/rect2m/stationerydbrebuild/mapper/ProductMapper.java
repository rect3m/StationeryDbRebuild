package com.rect2m.stationerydbrebuild.mapper;

import com.rect2m.stationerydbrebuild.entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper {
    private final Connection connection;

    private ProductMapper(Connection connection) {
        this.connection = connection;
    }

    public static ProductMapper getInstance(Connection connection) {
        return new ProductMapper(connection);
    }

    public void insert(Product product) throws SQLException {
        String sql = "INSERT INTO products (name, description, price, category_id, manufacturer_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setBigDecimal(3, product.getPrice());
            statement.setInt(4, product.getCategoryId());
            statement.setInt(5, product.getManufacturerId());
            statement.executeUpdate();
        }
    }

    public Product findById(int id) throws SQLException {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return buildProduct(resultSet);
                } else {
                    throw new RuntimeException("Product not found with id: " + id);
                }
            }
        }
    }

    private Product buildProduct(ResultSet resultSet) throws SQLException {
        return new Product.Builder()
                .setId(resultSet.getInt("id"))
                .setName(resultSet.getString("name"))
                .setDescription(resultSet.getString("description"))
                .setPrice(resultSet.getBigDecimal("price"))
                .setCategoryId(resultSet.getInt("category_id"))
                .setManufacturerId(resultSet.getInt("manufacturer_id"))
                .build();
    }
}
