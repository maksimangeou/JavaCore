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
    public boolean isContentTerm(String term) {
        boolean key = false;
        if (title.equals(term) || text.equals(term)) {
            key = true;
        }
        return key;
    }

    @Override
    public String searchTerm(String term) {
        return toString();
    }

    @Override
    public String getSearchedContent() {
        return "ARTICLE";
    }
}
