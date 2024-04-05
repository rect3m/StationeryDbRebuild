package com.rect2m.stationerydbrebuild.domain.serviceImpl;

import com.rect2m.stationerydbrebuild.domain.service.RegistrationService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class RegistrationServiceImpl implements RegistrationService {
    private final Connection connection;

    public RegistrationServiceImpl(Connection connection) {
        this.connection = connection;
    }


    public void registerUser(String username, String password) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO users (username, password) VALUES (?, ?)")) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}