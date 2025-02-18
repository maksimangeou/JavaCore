package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    private List<Product> basket;

    public ProductBasket() {
        basket = new LinkedList<>();
    }

    public List<Product> getBasket() {
        return basket;
    }

    public void setBasket(List<Product> basket) {
        this.basket = basket;
    }

    public void addProductIntoBasket(Product product) {
        basket.add(product);
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
        if (basket.isEmpty()) {
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
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто \n" +
                    "Продукт " + product.getName() + " не найден");
        } else if (isProductNameInBasket(product.getName())) {
            System.out.println("Продукт " + product.getName() + " найден");
        } else {
            System.out.println("Продукт " + product.getName() + " не найден");
        }
    }

    public void cleanBasket() {
        Iterator<Product> itrBasket = basket.iterator();
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            while (itrBasket.hasNext()) {
                itrBasket.next();
                itrBasket.remove();
            }
            System.out.println("Корзина очищена");
        }
    }

    public void removeProductFromBasket(String name) {
        Iterator<Product> itrBasket = basket.iterator();
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            Product nextPlaceBasket = itrBasket.next();
            if (nextPlaceBasket.getName().equals(name)) {
                itrBasket.remove();
                System.out.println("Продукт '" + name + "'удален");
            }
        }
    }
}
