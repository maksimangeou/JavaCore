package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private Product[] basket;
    private static int index = 0;

    public ProductBasket() {
        basket = new Product[5];
    }

    public Product[] getBasket() {
        return basket;
    }

    public void setBasket(Product[] basket) {
        this.basket = basket;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        ProductBasket.index = index;
    }

    public void addProductIntoBasket(Product product) {
        if (isIndexEmpty()) {
            basket[index] = product;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public boolean isIndexEmpty() {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                index = i;
                return true;
            }
        }
        return false;
    }

    public boolean isBasketEmpty() {
        boolean key = false;
        for (Product value : basket) {
            if (value == null) {
                key = true;
                break;
            }
        }
        return key;
    }

    public double getPriceBasket() {
        double price = 0;
        for (Product value : basket) {
            if (value != null) {
                price += value.getPrice();
            }
        }
        return price;
    }

    public void showPriceBasket() {
        System.out.println("Стоимость корзины: " + getPriceBasket());
    }

    public void showBasket() {
        int count = 0;
        if (isBasketEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            for (Product value : basket) {
                if (value != null && value.isSpecial()) {
                    System.out.println(value);
                    count++;
                } else if (value != null) {
                    System.out.println(value);
                }
            }
        }
        System.out.println("Итого: " + getPriceBasket() + '\n' + "Специальных товаров: " + count);
    }

    public boolean isProductNameInBasket(String name) {
        for (Product value : basket) {
            if (value.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void searchProductInBasket(Product product) {
        if (isBasketEmpty()) {
            System.out.println("В корзине пусто \n" +
                    "Продукт " + product.getName() + " не найден");
        } else if (isProductNameInBasket(product.getName())) {
            System.out.println("Продукт " + product.getName() + " найден");
        } else {
            System.out.println("Продукт " + product.getName() + " не найден");
        }
    }

    public void cleanBasket() {
        if (isBasketEmpty()) {
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
