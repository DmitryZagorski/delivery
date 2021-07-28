package org.example.order;

import java.util.List;

public interface OrderDataBase {

    List<Order> getOrdersFromFile();

    void writeOrdersToFile(List<Order> orders);
}
