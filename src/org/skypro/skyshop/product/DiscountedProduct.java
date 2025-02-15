package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int priceBase;
    private int discountPercent;

    public DiscountedProduct(String name, int priceBase, int discountPercent) {
        super(name);
        this.priceBase = priceBase;
        this.discountPercent = discountPercent;
    }

    public int getPriceBase() {
        return priceBase;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setPriceBase(int priceBase) {
        this.priceBase = priceBase;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public double getPrice() {
        double priceDiscount = priceBase * (1 - discountPercent / 100d);
        return Math.ceil(priceDiscount * 100) / 100;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discountPercent + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
