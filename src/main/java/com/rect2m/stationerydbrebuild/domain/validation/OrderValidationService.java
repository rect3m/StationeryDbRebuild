package com.rect2m.stationerydbrebuild.domain.validation;

import com.rect2m.stationerydbrebuild.persistence.validation.exception.ValidationIOException;

public class OrderValidationService {
    public static boolean isValidId(int id) {
        if (id <= 0) {
            throw new ValidationIOException("ID повинно бути більше нуля");
        }
        return true;
    }

    public static boolean isValidProductId(int productId) {
        if (productId <= 0) {
            throw new ValidationIOException("ID продукту повинно бути більше нуля");
        }
        return true;
    }

    public static boolean isValidQuantity(int quantity) {
        if (quantity <= 0) {
            throw new ValidationIOException("Кількість товару в замовленні повинна бути більше нуля");
        }
        return true;
    }
}
