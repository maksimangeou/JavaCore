package org.skypro.skyshop.article;

import org.skypro.skyshop.product.Searchable;

public final class Article implements Searchable {
    private String title;
    private String text;
    private static final String CODE_NULL = "non";

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String toString() {
        return title + '\n' + text;
    }

    @Override
    public boolean isContentTerm(String term) {
        boolean key = false;
        if (title.contains(term) || text.contains(term)) {
            key = true;
        }
        return key;
    }

    @Override
    public String searchTerm(String term) {
        if (isContentTerm(term)) {
            return toString();
        }
        return CODE_NULL;
    }

    @Override
    public String getSearchedContent() {
        return "ARTICLE";
    }
}
