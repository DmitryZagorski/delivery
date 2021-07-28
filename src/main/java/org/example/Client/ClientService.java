package org.example.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ClientService {

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
                System.out.println("Client with phone number '"+a+"' has deleted successfully.");
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
            System.out.println("Client was added successfully");
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
                System.out.println("Clients name was changed successfully");
            } else {
                System.out.println("Client with that phone number doesn't exist.");
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
                System.out.println("Clients phone number was changed successfully");
            } else {
                System.out.println("Client with that phone number doesn't exist.");
            }
        }
        clientDataBase.writeClientsToFile(clients);
    }
}
