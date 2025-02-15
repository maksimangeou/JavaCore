package org.skypro.skyshop.product.article;

import org.skypro.skyshop.product.Searchable;

public final class Article implements Searchable {
    private String title;
    private String text;

    @Override
    public String toString() {
        return title + '\n' + text;
    }

    @Override
    public String searchTerm(String term) {
        if (title.equals(term) || text.equals(term)) {
            return toString();
        }
        return null;
    }

    @Override
    public String getSearchedTitle() {
        return "ARTICLE";
    }
}
