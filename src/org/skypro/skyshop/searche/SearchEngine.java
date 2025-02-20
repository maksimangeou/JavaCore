package org.skypro.skyshop.searche;

import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.searchable.Searchable;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchItem;

    public SearchEngine() {
        this.searchItem = new LinkedList<>();
    }

    public List<Searchable> getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(List<Searchable> searchItem) {
        this.searchItem = searchItem;
    }

    public void add(Searchable searchable) {
        searchItem.add(searchable);
    }

    public boolean isSearched(String term, Searchable searchItem) {
        boolean key = true;
        if (searchItem.searchTerm(term).equals(Searchable.CODE_NULL)) {
            key = false;
        }
        return key;
    }

    public void search(String term) {
        for (Searchable searchItem : searchItem) {
            if (isSearched(term, searchItem)) {
                System.out.println(searchItem.getStringRepresentation(term) + '\n');
            }
        }
    }

    public Searchable searchMaxQualityTerm(String search) {
        Searchable searchable = null;
        int quality = 0;
        int qualityTemp = 0;
        int index = 0;
        for (Searchable searchItem : searchItem) {
            if (searchItem != null && isSearched(search, searchItem)) {
                String valueOfStringRepresentation = searchItem.getStringRepresentation(search);
                int indexSearch = valueOfStringRepresentation.indexOf(search, index);
                while (indexSearch != -1) {
                    quality++;
                    index = indexSearch + search.length();
                    indexSearch = valueOfStringRepresentation.indexOf(search, index);
                }

                if (qualityTemp < quality) {
                    qualityTemp = quality;
                    searchable = searchItem;
                }
            }
        }
        return searchable;
    }

    public void showSearchMaxQualityTerm(String search) {
        Searchable searchable = searchMaxQualityTerm(search);
        try {
            if (searchable == null) {
                throw new BestResultNotFound(search);
            }
            System.out.println(searchable);
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }
    }
}

