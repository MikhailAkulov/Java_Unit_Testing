package ru.gb.examples.Example_1.Tasks.Shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */

    public static void main(String[] args) {
        testSortProductsByPrise();
        testGetMostExpensiveProduct();
        testGetMostExpensiveProductExceptions();
    }

    public static void testSortProductsByPrise() {
        List<Product> products = Arrays.asList(
                new Product(70, "Milk"),
                new Product(53, "Bread"),
                new Product(50, "Water"),
                new Product(600, "Cheese"),
                new Product(100, "Pasta"));
        Shop shop = new Shop(products);
//        shop.sortProductsByPrice();
//        System.out.println(products);
        assertThat(shop.sortProductsByPrice()).isInstanceOf(List.class).containsAll(products);
        assertThat(shop.sortProductsByPrice().toArray().length).isEqualTo(products.toArray().length);
    }

    public static void testGetMostExpensiveProduct() {
        List<Product> products = Arrays.asList(
                new Product(70, "Milk"),
                new Product(53, "Bread"),
                new Product(50, "Water"),
                new Product(600, "Cheese"),
                new Product(100, "Pasta"));
        Shop shop = new Shop(products);
//        shop.getMostExpensiveProduct();
//        System.out.println(products.get(3));
        assertThat(shop.getMostExpensiveProduct()).isInstanceOf(Product.class).isEqualTo(products.get(3));
    }

    public static void testGetMostExpensiveProductExceptions() {
        List<Product> products = new ArrayList<Product>();
        Shop shop = new Shop(products);
        assertThatThrownBy(shop::getMostExpensiveProduct).isInstanceOf(NoSuchElementException.class);
    }
}