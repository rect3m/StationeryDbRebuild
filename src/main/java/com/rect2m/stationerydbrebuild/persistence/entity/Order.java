package com.rect2m.stationerydbrebuild.persistence.entity;

import java.util.Date;

public class Order {
    private final int id;
    private final Date date;
    private final int productId;
    private final int quantity;

    private Order(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.productId = builder.productId;
        this.quantity = builder.quantity;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public static class Builder {
        private int id;
        private Date date;
        private int productId;
        private int quantity;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder setProductId(int productId) {
            this.productId = productId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
