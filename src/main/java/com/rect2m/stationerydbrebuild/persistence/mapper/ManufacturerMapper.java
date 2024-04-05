package com.rect2m.stationerydbrebuild.persistence.mapper;

import com.rect2m.stationerydbrebuild.persistence.entity.Manufacturer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManufacturerMapper {
    private final Connection connection;

    private ManufacturerMapper(Connection connection) {
        this.connection = connection;
    }

    public static ManufacturerMapper getInstance(Connection connection) {
        return new ManufacturerMapper(connection);
    }

    public void insert(Manufacturer manufacturer) throws SQLException {
        String sql = "INSERT INTO manufacturers (name, country) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, manufacturer.getName());
            statement.setString(2, manufacturer.getCountry());
            statement.executeUpdate();
        }
    }

    public Manufacturer findById(int id) throws SQLException {
        String sql = "SELECT * FROM manufacturers WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return buildManufacturer(resultSet);
                } else {
                    throw new RuntimeException("Manufacturer not found with id: " + id);
                }
            }
        }
    }

    private Manufacturer buildManufacturer(ResultSet resultSet) throws SQLException {
        return new Manufacturer.Builder()
                .setId(resultSet.getInt("id"))
                .setName(resultSet.getString("name"))
                .setCountry(resultSet.getString("country"))
                .build();
    }
}
