package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.searche.SearchEngine;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(10);

        ProductBasket productBasket = new ProductBasket();

        System.out.println("Создание товаров и статей");
        Product orange = new SimpleProduct("апельсины", 100);
        Product cucumber = new SimpleProduct("огурцы", 199);
        Product tomato = new DiscountedProduct("помидоры", 200, 20);
        Product banana = new DiscountedProduct("бананы", 249, 30);
        Product milk = new FixPriceProduct("молоко");
        Product chocolate = new DiscountedProduct("шоколад", 39.99, 20);

        Article article1 = new Article("Польза апельсинов", "Текст номер 1");
        Article article2 = new Article("Садоводы и огородники", "Текст содержит в себе огурцы и помидоры");
        Article article3 = new Article("Молоко", "Лактоза - враг здоровью человека");

        System.out.println();

        System.out.println("Добавление позиций в массив поиска");
        searchEngine.add(orange);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(cucumber);
        searchEngine.add(article3);
        System.out.println();

        System.out.println("Поиск по ключевому слову");
        System.out.println("-апельсин");
        searchEngine.search("апельсин");
        System.out.println("-огородник");
        searchEngine.search("огородник");
        System.out.println("-огурцы");
        searchEngine.search("огурцы");
        System.out.println("-Лактоза");
        searchEngine.search("Лактоза");


        System.out.println("Добавление продуктов в корзину");
        productBasket.addProductIntoBasket(orange);
        productBasket.addProductIntoBasket(cucumber);
        productBasket.addProductIntoBasket(tomato);
        productBasket.addProductIntoBasket(banana);
        productBasket.addProductIntoBasket(milk);
        System.out.println();

        System.out.println("Добавление продукта в заполненную корзину");
        productBasket.addProductIntoBasket(chocolate);
        System.out.println();

        System.out.println("Печать содержимого корзины с несколькими товарами");
        productBasket.showBasket();
        System.out.println();

        System.out.println("Получение стоимости корзины с несколькими товарами");
        productBasket.showPriceBasket();
        System.out.println();

        System.out.println("Поиск товара, который есть в корзине");
        productBasket.searchProductInBasket(orange);
        System.out.println();

        System.out.println("Поиск товара, которого нет в корзине");
        productBasket.searchProductInBasket(chocolate);
        System.out.println();

        System.out.println("Очистка корзины");
        productBasket.cleanBasket();
        System.out.println();

        System.out.println("Печать содержимого пустой корзины");
        productBasket.showBasket();
        System.out.println();

        System.out.println("Получение стоимости пустой корзины");
        productBasket.showPriceBasket();
        System.out.println();

        System.out.println("Поиск товара по имени в пустой корзине");
        productBasket.searchProductInBasket(tomato);
    }
}
