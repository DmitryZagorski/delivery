package org.example.client;

import java.util.List;

public interface ClientDataBase {

    List<Client> getClientsFromFile();

    void writeClientsToFile(List<Client> clients);
}
