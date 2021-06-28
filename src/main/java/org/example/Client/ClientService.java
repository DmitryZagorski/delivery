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
        System.out.println("Enter the phone number of client you want to remove.");
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
        System.out.println("Enter the phone number if client you want to add.");
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
        System.out.println("Enter the phone number of client you want to change name.");
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
        System.out.println("Enter the phone number of client you want to change.");
        int a = Integer.parseInt(reader.readLine());
        for (Client client : clients) {
            if (a == client.getPhoneNumber()) {
                System.out.println("Enter new phone number.");
                int b = Integer.parseInt(reader.readLine());
                client.setPhoneNumber(b);
            } else {
                System.out.println("Client with that phone number already exist.");
            }
        }

        clientDataBase.writeClientsToFile(clients);
    }


}
