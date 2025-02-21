package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

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
        double price = 0;
        for (Map.Entry<String, List<Product>> valueBasket : basket.entrySet()) {
            for (Product value : valueBasket.getValue()) {
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
            for (Map.Entry<String, List<Product>> valueBasket : basket.entrySet()) {
                for (Product productValue : valueBasket.getValue()) {
                    if (productValue.isSpecial()) {
                        System.out.println(productValue);
                        count++;
                    } else {
                        System.out.println(productValue);
                    }
                }
            }
        }
        System.out.println("Итого: " + getPriceBasket() + '\n' + "Специальных товаров: " + count);
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