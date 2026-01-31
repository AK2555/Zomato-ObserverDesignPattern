package org.example.observable;

import org.example.models.Order;
import org.example.observer.RateOrderObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager {
    Map<String, Order> orderMap;
    List<RateOrderObserver> observers;

    public OrderManager(){
        this.orderMap=new HashMap<>();
        this.observers=new ArrayList<>();
    }

    public void orderFood(String orderId,String restaurantId,String foodItemId){
        Order order=new Order(orderId,restaurantId,foodItemId,0);
        orderMap.put(orderId,order);
    }

    public void rateOrder(String orderId,int rating){
        Order order=orderMap.get(orderId);
        order.setRating(rating);
        notifyAll(order);
    }

    public void addObserver(RateOrderObserver observer){
        observers.add(observer);
    }

    public void notifyAll(Order order){
        for(RateOrderObserver observer: observers){
            observer.update(order);
        }
    }
}
