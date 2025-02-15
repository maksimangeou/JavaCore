package org.skypro.skyshop.product;

import org.skypro.skyshop.product.searchable.Searchable;

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
    public String searchTerm(String term) {
        if (name.contains(term)) {
            return name;
        }
        return CODE_NULL;
    }

    @Override
    public String getSearchedContent() {
        return "PRODUCT";
    }
}
