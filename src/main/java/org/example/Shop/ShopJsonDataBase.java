package org.example.Shop;

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

public class ShopJsonDataBase implements ShopDataBase {
    private static final String FILE_SHOPS = "d:/q1/shops.json";
    private final Gson gson = new Gson();

    public ShopJsonDataBase() {
        if (!(new File(FILE_SHOPS).exists())){
        List<Shop> shops = new ArrayList<>();
        writeShopsToFile(shops);}
    }

    @Override
    public List<Shop> getShopsFromFile() {
        try (JsonReader jsonReader = new JsonReader(new FileReader(FILE_SHOPS))) {
            Type type = new TypeToken<List<Shop>>() {
            }.getType();
            return gson.fromJson(jsonReader, type);
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void writeShopsToFile(List<Shop> shops) {
        String shopsToJson = gson.toJson(shops);
        try (FileWriter writer = new FileWriter(new File(FILE_SHOPS))) {
            writer.write(shopsToJson);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
