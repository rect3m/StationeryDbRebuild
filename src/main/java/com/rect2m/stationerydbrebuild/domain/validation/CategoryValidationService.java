package com.rect2m.stationerydbrebuild.domain.validation;

import com.rect2m.stationerydbrebuild.persistence.validation.exception.ValidationIOException;

public class CategoryValidationService {
    public static boolean isValidId(int id) {
        if (id <= 0) {
            throw new ValidationIOException("ID повинно бути більше нуля");
        }
        return true;
    }

    public static boolean isValidName(String name) {
        boolean validName = name != null && !name.isEmpty() && name.length() <= 255;
        if (!validName) {
            throw new ValidationIOException("Назва категорії не може бути пустою і має бути не довшою за 255 символів");
        }
        return true;
    }
}
