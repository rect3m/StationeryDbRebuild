package com.rect2m.stationerydbrebuild.persistence.mapper;

import com.rect2m.stationerydbrebuild.persistence.entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Data Mapper для класу Category
public class CategoryMapper {
    private final Connection connection;

    private CategoryMapper(Connection connection) {
        this.connection = connection;
    }

    public static CategoryMapper getInstance(Connection connection) {
        return new CategoryMapper(connection);
    }

    public void insert(Category category) throws SQLException {
        String sql = "INSERT INTO categories (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, category.getName());
            statement.executeUpdate();
        }
    }

    public Category findById(int id) throws SQLException {
        String sql = "SELECT * FROM categories WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return buildCategory(resultSet);
                } else {
                    throw new RuntimeException("Category not found with id: " + id);
                }
            }
        }
    }

    private Category buildCategory(ResultSet resultSet) throws SQLException {
        return new Category.Builder()
                .setId(resultSet.getInt("id"))
                .setName(resultSet.getString("name"))
                .build();
    }
}
