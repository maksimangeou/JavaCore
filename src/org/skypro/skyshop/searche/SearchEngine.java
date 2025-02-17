package org.skypro.skyshop.searche;

import org.skypro.skyshop.exception.BestResultNotFound;
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
        int index = getEmptyPlaceIndex();
        if (index != -1) {
            searchItem[index] = searchable;
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

    public Searchable searchMaxQualityTerm(String search) {
        Searchable searchable = null;
        int quality = 0;
        int qualityTemp = 0;
        int index = 0;
            for (int i = 0; i < searchItem.length; i++) {
                if (searchItem[i] != null && isSearched(search, i)) {
                    int indexSearch = searchItem[i].getStringRepresentation(search).indexOf(search, index);
                    while (indexSearch != -1) {
                        quality++;
                        index = indexSearch + search.length();
                        indexSearch = searchItem[i].getStringRepresentation(search).indexOf(search, index);
                    }

                    if (qualityTemp < quality) {
                        qualityTemp = quality;
                        searchable = searchItem[i];
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

