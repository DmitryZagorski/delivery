package org.example.shop;

import java.util.List;

public interface ShopDataBase {

    List<Shop> getShopsFromFile();

    void writeShopsToFile(List<Shop> shops);

}
