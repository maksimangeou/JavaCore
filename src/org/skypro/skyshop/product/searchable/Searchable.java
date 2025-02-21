package org.skypro.skyshop.product.searchable;

public interface Searchable {

    String CODE_NULL = "non";

    String searchTerm(String term);

    String getSearchedContent();

    default String getStringRepresentation(String term) {
        return searchTerm(term) + '\n' + getSearchedContent();
    }


}
