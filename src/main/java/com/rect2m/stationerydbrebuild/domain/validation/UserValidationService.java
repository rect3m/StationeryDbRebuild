package com.rect2m.stationerydbrebuild.domain.validation;

import com.rect2m.stationerydbrebuild.persistence.entity.User;
import java.util.regex.Pattern;

public class UserValidationService {

    private static final int MIN_USERNAME_LENGTH = 6;
    private static final int MAX_USERNAME_LENGTH = 24;
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 30;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^(\\+\\d{1,4})?\\d{10}$");
    private static final Pattern ADDRESS_PATTERN = Pattern.compile("^[a-zA-Z0-9.,\\s\\d]{5,100}$");

    public static boolean isValidUsername(String username) {
        return username != null && username.length() >= MIN_USERNAME_LENGTH && username.length() <= MAX_USERNAME_LENGTH;
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= MIN_PASSWORD_LENGTH && password.length() <= MAX_PASSWORD_LENGTH;
    }

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches();
    }

    public static boolean isValidAddress(String address) {
        return address != null && ADDRESS_PATTERN.matcher(address).matches();
    }

    public static boolean isValidUser(User user) {
        return isValidUsername(user.getUsername()) &&
                isValidPassword(user.getPassword()) &&
                isValidEmail(user.getEmail()) &&
                isValidPhoneNumber(user.getPhoneNumber()) &&
                isValidAddress(user.getAddress());
    }
}
