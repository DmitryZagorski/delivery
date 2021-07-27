package org.example;

import org.example.Product.Product;
import org.example.Shop.ShopSQL;

import java.sql.*;
import java.util.List;

public class ShopSQLDataBase implements ShopSQL {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String NAME = "root";
    private static final String PASSWORD = "root";

    Connection connection;
    Statement statement;

    @Override
    public Connection getConnection() {
        try{
            if(connection!=null){
                return connection;
            }
            else {
                connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            }
            statement = connection.createStatement();
            if (!connection.isClosed()){
                System.out.println("Подключено к SQL");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public ResultSet getShopsFromSQL() {
        ResultSet resultSet=null;
        ResultSet resultSet1=null;

        try {
            resultSet = statement.executeQuery("select name from delivery.shops");
            resultSet1 = statement.executeQuery("select name from delivery.products");
            while (resultSet.next()){
                int id;
                String name;
                List<Product> productList;
                id = resultSet.getInt("id");
                name  = resultSet.getString("name");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
}
