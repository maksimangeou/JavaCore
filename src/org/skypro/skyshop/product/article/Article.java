package org.skypro.skyshop.product.article;

import org.skypro.skyshop.product.searchable.Searchable;

public final class Article implements Searchable {
    private String title;
    private String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return title + '\n' + text;
    }

    @Override
    public String searchTerm(String term) {
        if (title.contains(term) || text.contains(term)) {
            return toString();
        }
        return CODE_NULL;
    }

    @Override
    public String getSearchedContent() {
        return "ARTICLE";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
