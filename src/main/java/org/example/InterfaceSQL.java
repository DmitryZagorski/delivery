package org.example;

import org.example.Client.Client;

import java.sql.Connection;
import java.util.List;

public interface InterfaceSQL {
    Connection getConnection();

    List<Client> getListOfClientsFromSQL();

}
