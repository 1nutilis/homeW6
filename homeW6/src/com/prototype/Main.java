package com.prototype;

import java.util.List;

public class Main {
    public static void main(String[] args) {
      
        Product product1 = new Product("Ноутбук", 1500.00);
        Product product2 = new Product("Мышь", 25.00);


        List<Product> products = List.of(product1, product2);
        Order originalOrder = new Order(products, 20.0, 100.0, "Кредитная карта");
        System.out.println("Оригинальный заказ:\n" + originalOrder);


        Order clonedOrder = originalOrder.clone();
        System.out.println("Клонированный заказ:\n" + clonedOrder);
    }
}
