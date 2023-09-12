package repository;

import entity.Client;

import java.util.HashSet;
import java.util.Set;

public class ClientRepository implements IRepository<Client>{

    Set<Client> clients = new HashSet<>();
    private static int numberOfClients = 0;

    @Override
    public boolean register(Client client) {
        boolean contains = false;
        for (Client c : this.clients) {
            if (c.getDocument().equalsIgnoreCase(client.getDocument())) {
                contains = true;
                System.out.println("Client already exists, use Edit option.");
                break;
            }
        }
        if (!contains) {
            client.setId(numberOfClients);
            this.clients.add(client);
            numberOfClients += 1;
        }
        return !contains;
    }

    @Override
    public Client search(String document) {
        for (Client client : this.clients) {
            if (client.getDocument().equalsIgnoreCase(document)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public void edit(Client client) {

    }

    @Override
    public String toString() {
        String result = "";
        for (Client c : this.clients) {
            result += "\n" + c.toString();
        }
        return result;
    }
}
