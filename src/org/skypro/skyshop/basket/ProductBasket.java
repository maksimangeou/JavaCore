package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    Product[] basket;
    private static int index = 0;
    private static boolean key;

    public ProductBasket() {
        basket = new Product[5];
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        ProductBasket.index = index;
    }

    public void addProductIntoBasket(Product product) {
        if (isIndexEmpty()) {
            basket[getIndex()] = product;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public boolean isIndexEmpty() {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                setIndex(i);
                return true;
            }
        }
        return false;
    }

    public boolean isBasketEmpty() {
        for (int i = 0; i < basket.length; i++) {
            if (basket == null) {
                key = true;
            } else {
                key = false;
            }
        }
        return key;
    }

    public int getPriceBasket() {
        int price = 0;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                price += basket[i].getPrice();
            } else {
                continue;
            }
        }
        return price;
    }

    public void showPriceBasket() {
        System.out.println(getPriceBasket());
    }

    public void showBasket() {
        if (basket.length == 0) {
            System.out.println("В корзине пусто");
        }
        for (Product value : basket) {
            if (value != null) {
                System.out.println(value);
            } else {
                continue;
            }
        }
        System.out.println("Итого: " + getPriceBasket());
    }

    public boolean isProductNameInBasket(String name) {
        if (!key) {
            System.out.println("В корзине пусто");
        } else {
            for (Product value : basket) {
                if (value.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void searchProductInBasket(Product product) {
        if (isProductNameInBasket(product.getName())) {
            System.out.println("Продукт " + product.getName() + " найден");
        } else {
            System.out.println("Продукт " + product.getName() + " не найден");
        }
    }

    public void cleanBasket() {
        if (basket.length == 0) {
            System.out.println("В корзине пусто");
        } else {
            for (int i = 0; i < basket.length; i++) {
                if (basket[i] != null) {
                    basket[i] = null;
                }
            }
            System.out.println("Корзина очищена");
        }
    }
}
