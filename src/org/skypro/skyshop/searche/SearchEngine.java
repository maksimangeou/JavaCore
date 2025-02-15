package org.skypro.skyshop.searche;

import org.skypro.skyshop.product.searchable.Searchable;

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

    public boolean isSearched(String term, int index) {
        if (searchItem[index].searchTerm(term).equals(Searchable.CODE_NULL)) {
            return false;
        }
        return true;
    }

    public void search(String term) {
        int count = 0;
        for (int i = 0; i < searchItem.length; i++) {
            if (searchItem[i] != null && isSearched(term, i)) {
                count++;
                System.out.println(searchItem[i].getStringRepresentation(term) + '\n');
                if (count >= 5) {
                    break;
                } else if (searchItem[i].searchTerm(term) == null) {
                    break;
                }
            }
        }
    }
}
