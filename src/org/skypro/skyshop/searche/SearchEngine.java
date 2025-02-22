package org.skypro.skyshop.searche;

import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.searchable.Searchable;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> searchItem;

    public SearchEngine() {
        this.searchItem = new HashSet<>();
    }

    public Set<Searchable> getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(Set<Searchable> searchItem) {
        this.searchItem = searchItem;
    }

    public void add(Searchable searchable) {
        searchItem.add(searchable);
    }

    public boolean isSearched(String term, Searchable searchItem) {
        return !searchItem.searchTerm(term).equals(Searchable.CODE_NULL);
    }

    public Set<Searchable> search(String term) {
        Set<Searchable> setSearch = new TreeSet<>(new sortText());
        for (Searchable searchItem : searchItem) {
            if (isSearched(term, searchItem)) {
                setSearch.add(searchItem);
            }
        }
        return setSearch;
    }

    public static class sortText implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            int i1 = o1.toString().length();
            int i2 = o2.toString().length();
            int i = Integer.compare(i1,i2);
            if (i == 0) {
               return o1.toString().compareTo(o2.toString());
            }
            return i;
        }
    }

    public void showSearch(String term) {
        Set<Searchable> set = search(term);
        if (set.isEmpty()) {
            System.out.println("Корзина пустая");
        } else {
            System.out.println(set);
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

