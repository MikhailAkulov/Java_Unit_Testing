package main.java.ru.gb.examples.Example_1.Tasks.Shop;

import java.util.*;

public class Shop {
    private List<Product> products;

    public Shop(List<Product> products) {
        this.products = products;
    }

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getCost() - o2.getCost();
            }
        });
        return products;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() throws NoSuchElementException {
        if (products.size() == 0) {
            throw new NoSuchElementException("Product list is empty");
        }
        return Collections.max(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getCost() - o2.getCost();
            }
        });
    }
}