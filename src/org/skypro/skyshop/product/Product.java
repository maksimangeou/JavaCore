package org.skypro.skyshop.product;

public abstract class Product {

    private String name;

    public Product(String name) {
        this.name = name;
    }

    public abstract double getPrice();

    public abstract boolean isSpecial();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
