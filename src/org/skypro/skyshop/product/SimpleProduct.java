package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private double price;

    public SimpleProduct(String name, int price) {
        super(name);
        try {
            if (price > 0) {
                this.price = price;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Цена должна быть больше 0");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getName() + ": " + price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
