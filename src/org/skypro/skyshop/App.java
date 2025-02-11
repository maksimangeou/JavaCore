package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        Product orange = new Product("апельсины", 100);
        Product cucumber = new Product("огурцы", 199);
        Product tomato = new Product("помидоры", 200);
        Product banana = new Product("бананы", 249);
        Product milk = new Product("молоко", 68);
        Product chocolate = new Product("шоколад", 39);

        System.out.println("Добавление продуктов в корзину");
        productBasket.addProductIntoBasket(orange);
        productBasket.addProductIntoBasket(cucumber);
        productBasket.addProductIntoBasket(tomato);
        productBasket.addProductIntoBasket(banana);
        productBasket.addProductIntoBasket(milk);
        productBasket.showBasket();
        System.out.println();

        System.out.println("Добавление продукта в заполненную корзину");
        productBasket.addProductIntoBasket(chocolate);
        System.out.println();

        System.out.println("Печать содержимого корзины с несколькими товарами");
        productBasket.showBasket();
        System.out.println();

        System.out.println("Получение стоимости корзины с несколькими товарами");
        productBasket.getPriceBasket();
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
        productBasket.isProductNameInBasket(tomato.getName());
    }
}
