package com.rect2m.stationerydbrebuild.validation.impl;

import com.rect2m.stationerydbrebuild.validation.exception.ValidationIOException;
import java.math.BigDecimal;

public class ValidationImpl {

    public static boolean isValidId(int id) {
        if (id <= 0) {
            throw new ValidationIOException("ID повинно бути більше нуля");
        }
        return true;
    }

    public static boolean isValidNameCategory(String name) {
        boolean validName = name != null && name.matches("^[a-zA-Z0-9\\s'-]{2,50}$");
        if (!validName) {
            throw new ValidationIOException(
                    "Назва категорії може складатися з літер, цифр, пробілів, тире та апостроф, від 2 до 50 символів");
        }
        return true;
    }

    public static boolean isValidNameManufacturer(String name) {
        boolean validName = name != null && name.matches("^[a-zA-Z0-9\\s'-]{2,50}$");
        if (!validName) {
            throw new ValidationIOException(
                    "Назва виробника може складатися з літер, цифр, пробілів, тире та апостроф, від 2 до 50 символів");
        }
        return true;
    }

    public static boolean isValidCountryManufacturer(String country) {
        boolean validCountry = country != null && country.matches("^[a-zA-Z0-9\\s'-]{2,50}$");
        if (!validCountry) {
            throw new ValidationIOException(
                    "Країна виробника може складатися з літер, цифр, пробілів, тире та апостроф, від 2 до 50 символів");
        }
        return true;
    }


    public static boolean isValidProductIdOrder(int productId) {
        if (productId <= 0) {
            throw new ValidationIOException("ID продукту повинно бути більше нуля");
        }
        return true;
    }

    public static boolean isValidQuantityOrder(int quantity) {
        if (quantity <= 0) {
            throw new ValidationIOException(
                    "Кількість товару в замовленні повинна бути більше нуля");
        }
        return true;
    }

    public static boolean isValidNameProduct(String name) {
        boolean validName = name != null && !name.isEmpty() && name.length() <= 255;
        if (!validName) {
            throw new ValidationIOException("Назва продукту не може бути пустою і має бути не довшою за 255 символів");
        }
        return true;
    }

    public static boolean isValidDescriptionProduct(String description) {
        boolean validDescription = description == null || description.length() <= 1000;
        if (!validDescription) {
            throw new ValidationIOException("Опис продукту повинен бути не довшим за 1000 символів");
        }
        return true;
    }

    public static boolean isValidPriceProduct(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationIOException("Ціна продукту повинна бути більше нуля");
        }
        return true;
    }

    public static boolean isValidCategoryIdProduct(int categoryId) {
        if (categoryId <= 0) {
            throw new ValidationIOException("ID категорії повинно бути більше нуля");
        }
        return true;
    }

    public static boolean isValidManufacturerIdProduct(int manufacturerId) {
        if (manufacturerId <= 0) {
            throw new ValidationIOException("ID виробника повинно бути більше нуля");
        }
        return true;
    }
}