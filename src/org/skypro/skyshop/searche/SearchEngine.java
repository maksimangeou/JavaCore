package org.skypro.skyshop.searche;

import org.skypro.skyshop.product.Searchable;

public class SearchEngine {
    private Searchable[] searchItem;

    public SearchEngine(int size) {
        this.searchItem = new Searchable[size];
    }

    public Searchable[] getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(Searchable[] searchItem) {
        this.searchItem = searchItem;
    }

    public Searchable search(String term) {
        int count = 0;
        for (Searchable value: searchItem) {
            System.out.println(value.searchTerm(term).toString());
            count++;
            if (count <= 5 || count <= searchItem.length) {

            }
        }
    }
}
