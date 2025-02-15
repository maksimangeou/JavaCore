package org.skypro.skyshop.product;

public abstract class Product implements Searchable {

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

    @Override
    public boolean isContentTerm(String term) {
        boolean key = false;
        if (name.equals(term)) {
            key = true;
        }
        return key;
    }

    @Override
    public String searchTerm(String term) {
        if (isContentTerm(term)) {
            return name;
        }
        return null;
    }

    @Override
    public String getSearchedTitle() {
        return "PRODUCT";
    }
}
