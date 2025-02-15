package org.skypro.skyshop.product;

public interface Searchable {

    boolean isContentTerm(String term);

    String searchTerm(String term);

    String getSearchedContent();

    default String getStringRepresentation(String term) {
        return searchTerm(term) + '\n' + getSearchedContent();
    }
}
