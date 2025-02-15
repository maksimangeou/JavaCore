package org.skypro.skyshop.product.article;

import org.skypro.skyshop.product.Searchable;

public final class Article implements Searchable {
    private String title;
    private String text;

    @Override
    public String toString() {
        return title + '\n' + text;
    }
}
