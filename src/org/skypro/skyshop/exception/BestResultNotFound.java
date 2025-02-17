package org.skypro.skyshop.exception;

public class BestResultNotFound extends Exception{

    String search;

    public BestResultNotFound(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "BestResultNotFound {Поиск по ключевому слову '" + search + "' не дал результатов}";
    }
}
