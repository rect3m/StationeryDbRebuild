package com.rect2m.stationerydbrebuild.domain.serviceImpl;

import com.rect2m.stationerydbrebuild.domain.service.AuthorizationService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AuthorizationServiceImpl implements AuthorizationService {
    private final Connection connection;

    public AuthorizationServiceImpl(Connection connection) {
        this.connection = connection;
    }

    public boolean authorizeUser(String username, String password) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM users WHERE username = ? AND password = ?")) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Повертає true, якщо є користувач з таким ім'ям і паролем
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
