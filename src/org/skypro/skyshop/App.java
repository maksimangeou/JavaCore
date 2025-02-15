package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.searche.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(10);

        ProductBasket productBasket = new ProductBasket();

        Product orange = new SimpleProduct("апельсины", 100);
        Product cucumber = new SimpleProduct("огурцы", 199);
        Product tomato = new DiscountedProduct("помидоры", 200, 20);
        Product banana = new DiscountedProduct("бананы", 249, 30);
        Product milk = new FixPriceProduct("молоко");

        Article article1 = new Article("Польза апельсинов", "Текст номер 1");
        Article article2 = new Article("Садоводы и огородники","Текст содержит в себе огурцы и помидоры");
        Article article3 = new Article("Молоко", "Лактоза - враг здоровью человека");

        searchEngine.add(orange);
        searchEngine.add(article2);
        searchEngine.add(cucumber);
        searchEngine.add(article3);

        searchEngine.search("апельсин");
        searchEngine.search("огородник");
        searchEngine.search("огурцы");
        searchEngine.search("Лактоза");
    }
}
