package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Stream;

public class ProductBasket {

    private Map<String, List<Product>> basket;

    public ProductBasket() {
        basket = new LinkedHashMap<>();
    }

    public Map<String, List<Product>> getBasket() {
        return basket;
    }

    public void setBasket(Map<String, List<Product>> basket) {
        this.basket = basket;
    }

    public void addProductIntoBasket(Product product) {
        basket.computeIfAbsent(product.getName(), _ -> new ArrayList<>()).add(product);
    }

    public double getPriceBasket() {
        return basket.values()
                .stream()
                .flatMap(Collection::stream)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public void showPriceBasket() {
        System.out.println("Стоимость корзины: " + getPriceBasket());
    }

    private int getSpecialProduct() {
        return Math.toIntExact(basket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count());
    }

    public void showBasket() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            basket.values().stream()
                    .flatMap(Collection::stream)
                    .forEach(System.out::println);
        }
        System.out.println("Итого: " + getPriceBasket() + '\n' + "Специальных товаров: " + getSpecialProduct());
    }

    public boolean isProductNameInBasket(String name) {
        for (Map.Entry<String, List<Product>> valueBasket : basket.entrySet()) {
            for (Product value : valueBasket.getValue()) {
                if (value.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void searchProductInBasket(Product product) {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто \n" + "Продукт " + product.getName() + " не найден");
        } else if (isProductNameInBasket(product.getName())) {
            System.out.println("Продукт " + product.getName() + " найден");
        } else {
            System.out.println("Продукт " + product.getName() + " не найден");
        }
    }

    public void cleanBasket() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            basket.clear();
            System.out.println("Корзина очищена");
        }
    }

    public List<Product> removeProductFromBasket(String name) {
        List<Product> listRemove = new LinkedList<>();
        for (Map.Entry<String, List<Product>> valueBasket : basket.entrySet()) {
            Iterator<Product> itrBasket = valueBasket.getValue().iterator();
            while (itrBasket.hasNext()) {
                Product nextPlaceBasket = itrBasket.next();
                if (nextPlaceBasket.getName().equals(name)) {
                    listRemove.add(nextPlaceBasket);
                    itrBasket.remove();
                }
            }
        }
        return listRemove;
    }

    public void showRemoveProductFromBasket(String name) {
        List<Product> value = removeProductFromBasket(name);
        StringBuilder stb = new StringBuilder();
        if (value.isEmpty()) {
            System.out.println("Продукт не найден в корзине");
        } else {
            stb.append("Список удаленных продуктов: \n");
            for (Product product : value) {
                stb.append(product).append('\n');
            }
            System.out.println(stb);
        }
    }
}