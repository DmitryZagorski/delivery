package org.example.Client;

import org.example.InterfaceSQL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    public InterfaceSQL interfaceSQL;

    public ClientService(InterfaceSQL interfaceSQL) {
        this.interfaceSQL = interfaceSQL;
    }

    private ClientDataBase clientDataBase;

    public ClientService(ClientDataBase clientDataBase) {
        this.clientDataBase = clientDataBase;
    }

    public void printClientList() {
        List<Client> clients = clientDataBase.getClientsFromFile();

        System.out.println("The client list: ");
        for (Client client : clients) {
            System.out.println(client.getName() + " : +375" + client.getPhoneNumber());
        }
    }

    public void deleteClientFromClientList() throws IOException {
        List<Client> clients = clientDataBase.getClientsFromFile();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the phone number of client you want to remove. ( 9 digits)");
        int a = Integer.parseInt(reader.readLine());
        int count = 0;
        for (Client client : clients) {
            if (a == client.getPhoneNumber()) {
                clients.remove(client);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Client with that phone number doesn't exist.");
        }

        clientDataBase.writeClientsToFile(clients);
    }


    public void addClientToClientList() throws IOException {
        List<Client> clients = clientDataBase.getClientsFromFile();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the name of client you want to add.");
        String a = reader.readLine();
        System.out.println("Enter the phone number if client you want to add.(9 digits)");
        int b = Integer.parseInt(reader.readLine());
        int count = 0;
        for (Client client : clients) {
            if ((client.getPhoneNumber()) == b) {
                count++;
            }
        }
        String r = b + "";
        String[] array = r.split("");
        if (count == 0 && array.length == 9) {
            clients.add(new Client(a, b));
        }
        if (count > 0) {
            System.out.println("Client with that phone number already exist.");
        }

        clientDataBase.writeClientsToFile(clients);
    }

    public void changeNameOfClientByPhoneNumber() throws IOException {
        List<Client> clients = clientDataBase.getClientsFromFile();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the phone number of client you want to change name.(9 digits)");
        int a = Integer.parseInt(reader.readLine());
        for (Client client : clients) {
            if (a == client.getPhoneNumber()) {
                System.out.println("Enter new name.");
                String b = reader.readLine();
                client.setName(b);
            } else {
                System.out.println("Client with that phone number already exist.");
            }
        }

        clientDataBase.writeClientsToFile(clients);
    }

    public void changePhoneNumberOfClientByPhoneNumber() throws IOException {
        List<Client> clients = clientDataBase.getClientsFromFile();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the phone number of client you want to change.(9 digits)");
        int a = Integer.parseInt(reader.readLine());
        for (Client client : clients) {
            if (a == client.getPhoneNumber()) {
                System.out.println("Enter new phone number.(9 digits)");
                int b = Integer.parseInt(reader.readLine());
                client.setPhoneNumber(b);
            } else {
                System.out.println("Client with that phone number already exist.");
            }
        }

        clientDataBase.writeClientsToFile(clients);
    }

    //     SQL

    public void addClientToListSQL() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the name of client you want to add to SQL.");
        String nameR = reader.readLine();
        System.out.println("Enter the phone number if client you want to add to SQL.(9 digits)");
        int phoneR = Integer.parseInt(reader.readLine());
        Connection connection = interfaceSQL.getConnection();
        Statement statement = null;

        List<Client> clients = interfaceSQL.getListOfClientsFromSQL();
        int count = 0;
        for (Client client : clients) {
            if (client.getPhoneNumber() == phoneR) {
                count++;
            }
        }
        String r = phoneR + "";
        String[] array = r.split("");
        if (count == 0 && array.length == 9) {
            try{
                statement = connection.createStatement();
               // statement.execute("insert into delivery.clients (name, phoneNumber) values" +
                 //       " (" + nameR + "," + phoneR + ")");
                String q = "insert into delivery.clients (name, phoneNumber) values" +
                        " (" + nameR + "," + phoneR + ")";
                statement.execute(q);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (count > 0) {
            System.out.println("Client with that phone number already exist.");
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
