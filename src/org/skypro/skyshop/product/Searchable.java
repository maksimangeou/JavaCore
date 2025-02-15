package org.skypro.skyshop.product;

public interface Searchable {

    String searchTerm(String term);

    String getSearchedTitle();

    default String getStringRepresentation() {
        return null;
    }
}
