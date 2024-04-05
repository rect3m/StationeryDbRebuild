package com.rect2m.stationerydbrebuild.domain.service;

public interface AuthorizationService {
    boolean authenticate(String username, String password);
}
