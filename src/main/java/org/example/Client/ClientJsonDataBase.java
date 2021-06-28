package org.example.Client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ClientJsonDataBase implements ClientDataBase {
    private final static String FILE_CLIENTS = "d:/q1/clients.json";
    Gson gson = new Gson();

    public ClientJsonDataBase() {
        if (!(new File(FILE_CLIENTS).exists())){
        List<Client> clients = new ArrayList<>();
        writeClientsToFile(clients);}
    }

    @Override
    public List<Client> getClientsFromFile() {
        try (JsonReader jsonReader = new JsonReader(new FileReader(FILE_CLIENTS))) {
            Type type = new TypeToken<List<Client>>() {
            }.getType();
            return gson.fromJson(jsonReader, type);
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void writeClientsToFile(List<Client> clients) {
        String shopsToJson = gson.toJson(clients);
        try (FileWriter writer = new FileWriter(new File(FILE_CLIENTS))) {
            writer.write(shopsToJson);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }
}
