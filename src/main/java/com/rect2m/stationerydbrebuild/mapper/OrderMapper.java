package com.rect2m.stationerydbrebuild.mapper;

import com.rect2m.stationerydbrebuild.entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper {
    private final Connection connection;

    private OrderMapper(Connection connection) {
        this.connection = connection;
    }

    public static OrderMapper getInstance(Connection connection) {
        return new OrderMapper(connection);
    }

    public void insert(Order order) throws SQLException {
        String sql = "INSERT INTO orders (date, product_id, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, new java.sql.Date(order.getDate().getTime()));
            statement.setInt(2, order.getProductId());
            statement.setInt(3, order.getQuantity());
            statement.executeUpdate();
        }
    }

    public Order findById(int id) throws SQLException {
        String sql = "SELECT * FROM orders WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return buildOrder(resultSet);
                } else {
                    throw new RuntimeException("Order not found with id: " + id);
                }
            }
        }
    }

    private Order buildOrder(ResultSet resultSet) throws SQLException {
        return new Order.Builder()
                .setId(resultSet.getInt("id"))
                .setDate(resultSet.getDate("date"))
                .setProductId(resultSet.getInt("product_id"))
                .setQuantity(resultSet.getInt("quantity"))
                .build();
    }
}
