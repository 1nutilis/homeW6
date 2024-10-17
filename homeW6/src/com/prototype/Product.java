package com.prototype;

public class Product implements IPrototype<Product>{
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public Product clone() {
        return new Product(name, price);
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }

}
