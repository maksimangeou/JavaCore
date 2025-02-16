package org.skypro.skyshop.searche;

import org.skypro.skyshop.product.searchable.Searchable;

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

    public int getEmptyPlaceIndex() {
        for (int i = 0; i < searchItem.length; i++) {
            if (searchItem[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void add(Searchable searchable) {
        if (getEmptyPlaceIndex() != -1) {
            searchItem[getEmptyPlaceIndex()] = searchable;
        } else {
            System.out.println("Нет места для добавления");
        }
    }

    public boolean isSearched(String term, int index) {
        boolean key = true;
        if (searchItem[index] == null) {
            key = false;
        } else if (searchItem[index].searchTerm(term).equals(Searchable.CODE_NULL)) {
            key = false;
        }
        return key;
    }

    public void search(String term) {
        int count = 0;
        for (int i = 0; i < searchItem.length; i++) {
            if (isSearched(term, i)) {
                count++;
                System.out.println(searchItem[i].getStringRepresentation(term) + '\n');
            } else {
                continue;
            }
            if (count >= 5) {
                break;
            }
        }
    }
}

