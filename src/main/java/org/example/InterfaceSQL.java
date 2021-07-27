package org.example.Shop;

import java.sql.Connection;
import java.sql.ResultSet;

public interface ShopSQL {
    Connection getConnection();

    ResultSet getShopsFromSQL();



}
