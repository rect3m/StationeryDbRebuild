package com.rect2m.stationerydbrebuild.entity;

import java.math.BigDecimal;

public class Product {
    private final int id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final int categoryId;
    private final int manufacturerId;

    private Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.categoryId = builder.categoryId;
        this.manufacturerId = builder.manufacturerId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public static class Builder {
        private int id;
        private String name;
        private String description;
        private BigDecimal price;
        private int categoryId;
        private int manufacturerId;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder setCategoryId(int categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder setManufacturerId(int manufacturerId) {
            this.manufacturerId = manufacturerId;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
