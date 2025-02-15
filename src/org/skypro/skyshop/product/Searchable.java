package org.skypro.skyshop.product;

public interface Searchable {

    boolean isContentTerm(String term);

    String searchTerm(String term);

    String getSearchedTitle();

    default String getStringRepresentation() {
        return null;
    }
}
