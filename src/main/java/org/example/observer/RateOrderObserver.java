package org.example.observer;

import org.example.models.Order;

public interface RateOrderObserver {
    void update(Order order);
}
