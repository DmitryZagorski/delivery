package org.example.Order;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class OrderJsonDataBase implements OrderDataBase {
    private final static String FILE_ORDERS = "d:/q1/orders.json";
    Gson gson = new Gson();

    public OrderJsonDataBase() {
        if (!(new File(FILE_ORDERS).exists())){
        List<Order> orders = new ArrayList<>();
        writeOrdersToFile(orders);}
    }

    @Override
    public List<Order> getOrdersFromFile() {
        try (JsonReader reader = new JsonReader(new FileReader(FILE_ORDERS))) {
            Type type = new TypeToken<List<Order>>() {
            }.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void writeOrdersToFile(List<Order> orders) {
        String ordersToJson = gson.toJson(orders);
        try (FileWriter writer = new FileWriter(new File(FILE_ORDERS))) {
            writer.write(ordersToJson);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
