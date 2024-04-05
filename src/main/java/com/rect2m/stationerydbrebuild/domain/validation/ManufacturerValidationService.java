package com.rect2m.stationerydbrebuild.domain.validation;

import com.rect2m.stationerydbrebuild.persistence.validation.exception.ValidationIOException;

public class ManufacturerValidationService {
    public static boolean isValidId(int id) {
        if (id <= 0) {
            throw new ValidationIOException("ID повинно бути більше нуля");
        }
        return true;
    }

    public static boolean isValidName(String name) {
        boolean validName = name != null && !name.isEmpty() && name.length() <= 255;
        if (!validName) {
            throw new ValidationIOException("Назва виробника не може бути пустою і має бути не довшою за 255 символів");
        }
        return true;
    }

    public static boolean isValidCountry(String country) {
        boolean validCountry = country != null && !country.isEmpty() && country.length() <= 255;
        if (!validCountry) {
            throw new ValidationIOException("Назва країни виробника не може бути пустою і має бути не довшою за 255 символів");
        }
        return true;
    }
}
