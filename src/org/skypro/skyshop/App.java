package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.product.article.Article;
import org.skypro.skyshop.searche.SearchEngine;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();

        ProductBasket productBasket = new ProductBasket();

        System.out.println("Демонстрация ошибок");
        System.out.println("NULL в имени");
        Product productNullInName = new SimpleProduct(null, 100);
        System.out.println("Пробелы в имени");
        Product productNameOfSpaces = new SimpleProduct("   ", 100);
        System.out.println("Нулевая цена");
        Product productZeroPrice = new SimpleProduct("milk", 0);
        System.out.println("Скидка более 100%");
        Product productDiscountOverHundredPercent = new DiscountedProduct("vine", 500, 120);
        System.out.println("Скидка менее 0%");
        Product productDiscountLessZeroPercent = new DiscountedProduct("juice", 500, -5);
        System.out.println();

        System.out.println("Создание товаров и статей");
        Product orange = new SimpleProduct("апельсин", 100);
        Product cucumber = new SimpleProduct("огурцы", 199);
        Product tomato = new DiscountedProduct("помидоры", 200, 20);
        Product banana = new DiscountedProduct("бананы", 249, 30);
        Product milk = new FixPriceProduct("молоко");
        Product chocolate = new DiscountedProduct("шоколад", 39.99, 20);
        Product potato = new DiscountedProduct("картофель", 59.99, 5);

        Article article1 = new Article("Польза апельсинов", "Текст номер 1 про апельсины");
        Article article2 = new Article("Садоводы и огородники", "Текст содержит в себе огурцы и помидоры");
        Article article3 = new Article("Молоко1", "Лактоза1 - враг здоровью человека");
        Article article4 = new Article("Молоко2", "Лактоза2 - враг здоровью человека");
        Article article5 = new Article("Молоко3", "Лактоза3, Молоко - враг здоровью человека");
        Article article6 = new Article("Молоко4", "Лактоза4 - враг здоровью человека");
        Article article7 = new Article("Молоко5", "Лактоза5 - враг здоровью человека");
        Article article8 = new Article("Молоко6", "Лактоза6 - враг здоровью человека"); //чтобы проверить вывод не более 5 результатов
        Article article9 = new Article("Еще одна статья об апельсинах", "Текст два");
        System.out.println();

        System.out.println("Добавление позиций в массив поиска");
        searchEngine.add(orange);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(tomato);
        searchEngine.add(article3);
        searchEngine.add(article4);
        searchEngine.add(article5);
        searchEngine.add(article6);
        searchEngine.add(article7);
        searchEngine.add(article8);
        searchEngine.add(article9);
        System.out.println();

        System.out.println("Поиск по ключевому слову");
        System.out.println("-апельсин");
        searchEngine.search("апельсин");
        System.out.println("-огородник");
        searchEngine.search("огородник");
        System.out.println("-помидоры");
        searchEngine.search("помидоры");
        System.out.println("-Лактоза");
        searchEngine.search("Лактоза");
        System.out.println();

        System.out.println("Поиск по ключевому слову максимальное кол-во повторений");
        System.out.println("-апельсины");
        searchEngine.showSearchMaxQualityTerm("апельсин");
        System.out.println();
        System.out.println("-яблоки");
        searchEngine.showSearchMaxQualityTerm("яблоки");
        System.out.println();


        System.out.println("Добавление продуктов в корзину");
        productBasket.addProductIntoBasket(orange);
        productBasket.addProductIntoBasket(cucumber);
        productBasket.addProductIntoBasket(tomato);
        productBasket.addProductIntoBasket(banana);
        productBasket.addProductIntoBasket(milk);
        productBasket.addProductIntoBasket(orange);
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
        productBasket.searchProductInBasket(potato);
        System.out.println();

        System.out.println("Удаление продукта по ключевому слову");
        System.out.println("-апельсины");
        productBasket.showRemoveProductFromBasket("апельсин");
        System.out.println("-молоко");
        productBasket.showRemoveProductFromBasket("молоко");
        System.out.println("несуществующий в корзине - яблоки");
        productBasket.showRemoveProductFromBasket("яблоки");
        System.out.println();
        productBasket.showBasket();
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
