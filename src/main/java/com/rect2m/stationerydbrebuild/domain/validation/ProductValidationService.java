package com.rect2m.stationerydbrebuild.domain.validation;

import com.rect2m.stationerydbrebuild.persistence.validation.exception.ValidationIOException;
import java.math.BigDecimal;

public class ProductValidationService {
    public static boolean isValidId(int id) {
        if (id <= 0) {
            throw new ValidationIOException("ID повинно бути більше нуля");
        }
        return true;
    }

    public static boolean isValidName(String name) {
        boolean validName = name != null && !name.isEmpty() && name.length() <= 255;
        if (!validName) {
            throw new ValidationIOException("Назва продукту не може бути пустою і має бути не довшою за 255 символів");
        }
        return true;
    }

    public static boolean isValidDescription(String description) {
        boolean validDescription = description == null || description.length() <= 1000;
        if (!validDescription) {
            throw new ValidationIOException("Опис продукту повинен бути не довшим за 1000 символів");
        }
        return true;
    }

    public static boolean isValidPrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationIOException("Ціна продукту повинна бути більше нуля");
        }
        return true;
    }

    public static boolean isValidCategoryId(int categoryId) {
        if (categoryId <= 0) {
            throw new ValidationIOException("ID категорії повинно бути більше нуля");
        }
        return true;
    }

    public static boolean isValidManufacturerId(int manufacturerId) {
        if (manufacturerId <= 0) {
            throw new ValidationIOException("ID виробника повинно бути більше нуля");
        }
        return true;
    }
}
