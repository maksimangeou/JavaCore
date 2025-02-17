package org.skypro.skyshop.product;

import org.skypro.skyshop.product.searchable.Searchable;

public abstract class Product implements Searchable {

    private String name;

    public Product(String name) {
        try {
            if (!name.isBlank()) {
                this.name = name;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Название состоит из пробелов");
        } catch (NullPointerException e) {
            System.out.println("Пустое значение в аргументе");
        }
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
