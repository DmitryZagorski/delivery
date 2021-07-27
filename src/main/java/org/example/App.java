package org.example;

import org.example.Client.ClientDataBase;
import org.example.Client.ClientJsonDataBase;
import org.example.Client.ClientService;
import org.example.Order.OrderDataBase;
import org.example.Order.OrderJsonDataBase;
import org.example.Order.OrderService;
import org.example.Shop.ShopDataBase;
import org.example.Shop.ShopJsonDataBase;
import org.example.Shop.ShopService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws IOException, SQLException {

        InterfaceSQL interfaceSQL = new SQLConnector();

        ShopDataBase shopDataBase = new ShopJsonDataBase();
        ShopService shopService = new ShopService(shopDataBase);
        ShopService shopService1 = new ShopService(interfaceSQL);

        OrderDataBase orderDataBase = new OrderJsonDataBase();
        OrderService orderService = new OrderService(orderDataBase);
        OrderService orderService1 = new OrderService(interfaceSQL);

        ClientDataBase clientDataBase = new ClientJsonDataBase();
        ClientService clientService = new ClientService(clientDataBase);
        ClientService clientService1 = new ClientService(interfaceSQL);


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello!\n" +
                "To add the order you should add a new Client.\n" +
                "Press '1' if you are the manager.\n" +
                "Press '2' if you are the client.");
        String a = reader.readLine();
        while (!a.equals("end")) {
            if (a.equals("1")) {
                System.out.println("Enter the password (Password:\"123\"). You can try 3 times.");
                String password = "";
                int count = 0;
                while (!(password.equals("123")) && count < 3) {
                    password = reader.readLine();
                    count++;
                    if (!password.equals("123")) {
                        System.out.println("Wrong password.");
                    }
                }
                if (password.equals("123") && count < 3) {
                    System.out.println("What do you want to do?\n" +
                            "'1' - do something with shops.\n" +
                            "'2' - do something with clients.\n" +
                            "'3' - do something with orders.");
                    String s = reader.readLine();
                    if (s.equals("1")) {
                        System.out.println(
                                "'1' - view shop list.\n" +
                                        "'2' - add shop to shop list.\n" +
                                        "'3' - remove shop from shop list.\n" +
                                        "'4' - view all products all over the shops.\n" +
                                        "'5' - add product to shop.\n" +
                                        "'6' - remove product from the shop.\n" +
                                        "'7' - view product list of the shop.\n" +
                                        "'8' - change product price in the shop.\n" +
                                        "'9' - change product count in the shop.\n" +
                                        "'10' - view products in shops by product category.\n" +
                                        "'11' - view products in shops by name.\n");
                        String a2 = reader.readLine();
                        if (a2.equals("1")) {
                            shopService.printShopList();
                        }
                        if (a2.equals("2")) {
                            shopService.addShopToShopList();
                        }
                        if (a2.equals("3")) {
                            shopService.deleteShopFromShopList();
                        }
                        if (a2.equals("4")) {
                            shopService.printAllProductsInTheShops();
                        }
                        if (a2.equals("5")) {
                            shopService.addProductsToShop();
                        }
                        if (a2.equals("6")) {
                            shopService.deleteProductsFromShop();
                        }
                        if (a2.equals("7")) {
                            shopService.printProductListInTheShop();
                        }
                        if (a2.equals("8")) {
                            shopService.changePriceOfProductInTheShop();
                        }
                        if (a2.equals("9")) {
                            shopService.changeCountOfProductInTheShop();
                        }
                        if (a2.equals("10")) {
                            shopService.findProductInShopsByProductCategory();
                        }
                        if (a2.equals("11")) {
                            shopService.findProductInShopsByName();
                        }
                    }
                    if (s.equals("2")) {
                        System.out.println(
                                "'1' - add client to client list.\n" +
                                        "'2' - remove client from client list.\n" +
                                        "'3' - view client list.\n" +
                                        "'4' - change name of the client by phone number.\n" +
                                        "'5' - change phone number of client by phone number.");
                        String s1 = reader.readLine();
                        if (s1.equals("1")) {
                            clientService.addClientToClientList();
                            clientService1.addClientToListSQL();
                        }
                        if (s1.equals("2")) {
                            clientService.deleteClientFromClientList();
                        }
                        if (s1.equals("3")) {
                            clientService.printClientList();
                        }
                        if (s1.equals("4")) {
                            clientService.changeNameOfClientByPhoneNumber();
                        }
                        if (s1.equals("5")) {
                            clientService.changePhoneNumberOfClientByPhoneNumber();
                        }
                    }

                    if (s.equals("3")) {
                        System.out.println(
                                "'1' - add new order.\n" +
                                        "'2' - delete order.\n" +
                                        "'3' - view list of orders.");
                        String s2 = reader.readLine();
                        if (s2.equals("1")) {
                            orderService.addOrderToOrderList();
                        }
                        if (s2.equals("2")) {
                            orderService.deleteOrderFromOrderList();
                        }
                        if (s2.equals("3")) {
                            orderService.printListOfOrders();
                        }
                    }
                }
            }

            if (a.equals("2")) {
                System.out.println("What do you want to do?\n" +
                        "'1' - do something with shops.\n" +
                        "'2' - do something with clients.\n" +
                        "'3' - do something with orders.");
                String c = reader.readLine();
                if (c.equals("1")) {
                    System.out.println(
                            "'1' - view shop list.\n" +
                                    "'2' - view product list of the shop.\n" +
                                    "'3' - view products in shops by product category.\n" +
                                    "'4' - view products in shops by name.\n" +
                                    "'5' - view all products all over the shops. ");
                    String c1 = reader.readLine();
                    if (c1.equals("1")) {
                        shopService.printShopList();
                    }
                    if (c1.equals("2")) {
                        shopService.printProductListInTheShop();
                    }
                    if (c1.equals("3")) {
                        shopService.findProductInShopsByProductCategory();
                    }
                    if (c1.equals("4")) {
                        shopService.findProductInShopsByName();
                    }
                    if (c1.equals("5")) {
                        shopService.printAllProductsInTheShops();
                    }
                }
                if (c.equals("2")) {
                    System.out.println(
                            "'1' - add client to client list.\n" +
                                    "'2' - remove client from client list.\n");
                    String c1 = reader.readLine();
                    if (c1.equals("1")) {
                        clientService.addClientToClientList();
                    }
                    if (c1.equals("2")) {
                        clientService.deleteClientFromClientList();
                    }
                }
                if (c.equals("3")) {
                    System.out.println(
                            "'1' - add new order.\n" +
                                    "'2' - delete order.");
                    String c1 = reader.readLine();
                    if (c1.equals("1")) {
                        orderService.addOrderToOrderList();
                    }
                    if (c1.equals("2")) {
                        orderService.deleteOrderFromOrderList();
                    }
                }
            }
        }
    }

}

