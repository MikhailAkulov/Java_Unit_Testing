package ru.gb.examples.Example_1.Tasks.Shop;

public class Product {
    private Integer cost; // Стоимость продукта
    private String title; // Название

    public Product(int cost, String title) {
        this.cost = cost;
        this.title = title;
    }

    // Геттеры, сеттеры:
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}