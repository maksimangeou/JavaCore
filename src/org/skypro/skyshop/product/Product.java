package org.skypro.skyshop.product;

import org.skypro.skyshop.product.searchable.Searchable;

import java.lang.runtime.SwitchBootstraps;

public abstract class Product implements Searchable, Comparable<Product> {

    private String name;

    public Product(String name) {
        try {
            if (name.isBlank()) {
                throw new IllegalArgumentException();
            }
            this.name = name;
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

    @Override
    public int compareTo(Product other) {
        return name.compareTo(other.name);
    }
}
