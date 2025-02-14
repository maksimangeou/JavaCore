package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        Product orange = new SimpleProduct("апельсины", 100);
        Product cucumber = new SimpleProduct("огурцы", 199);
        Product tomato = new DiscountedProduct("помидоры", 200, 20);
        Product banana = new DiscountedProduct("бананы", 249, 30);
        Product milk = new FixPriceProduct("молоко");
        Product chocolate = new SimpleProduct("шоколад", 39);

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
