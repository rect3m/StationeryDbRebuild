package com.rect2m.stationerydbrebuild.entity;

public class Manufacturer {
    private final int id;
    private final String name;
    private final String country;

    private Manufacturer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.country = builder.country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public static class Builder {
        private int id;
        private String name;
        private String country;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Manufacturer build() {
            return new Manufacturer(this);
        }
    }
}
