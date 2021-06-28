package org.example.Client;

import java.util.List;

public interface ClientDataBase {

    List<Client> getClientsFromFile();

    void writeClientsToFile(List<Client> clients);

}
