package com.prototype;

import java.util.ArrayList;
import java.util.List;

public class Order implements IPrototype<Order>{
    private List<Product> products;
    private double deliveryCost;
    private double discount;
    private String paymentMethod;

    public Order(List<Product> products, double deliveryCost, double discount, String paymentMethod) {
        this.products = new ArrayList<>(products);
        this.deliveryCost = deliveryCost;
        this.discount = discount;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public Order clone() {
        return new Order(new ArrayList<>(products), deliveryCost, discount, paymentMethod);
    }

    @Override
    public String toString() {
        return "Заказ: " + products + ", Доставка: $" + deliveryCost + ", Скидка: $" + discount + ", Оплата: " + paymentMethod;
    }
}
