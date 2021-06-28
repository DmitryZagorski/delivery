package org.example.Shop;

import java.util.List;

public interface ShopDataBase {

    List<Shop> getShopsFromFile();

    void writeShopsToFile(List<Shop> shops);


}
