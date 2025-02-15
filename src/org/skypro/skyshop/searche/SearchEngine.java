package org.skypro.skyshop.searche;

import org.skypro.skyshop.product.Searchable;

public class SearchEngine {
    private Searchable[] searchItem;
    private static int index;

    public SearchEngine(int size) {
        this.searchItem = new Searchable[size];
    }

    public Searchable[] getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(Searchable[] searchItem) {
        this.searchItem = searchItem;
    }

    public boolean isEmptyPlace() {
        for (int i = 0; i < searchItem.length; i++) {
            if (searchItem[i] == null) {
                index = i;
                return true;
            }
        }
        return false;
    }
    public void add(Searchable searchable) {
        if (isEmptyPlace()) {
            searchItem[index] = searchable;
        }
    }

    public void search(String term) {
        int count = 0;
        for (Searchable value: searchItem) {
            if (value.searchTerm(term) != null) {
                count++;
                System.out.println(value.getStringRepresentation(term)+'\n');
                if (count == 5 || count < searchItem.length) {
                    break;
                }
            }
        }
    }
}
