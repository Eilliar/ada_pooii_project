package repository;

import entity.Client;

import java.util.HashSet;
import java.util.Set;

public class ClientRepository implements IRepository<Client>{

    Set<Client> clients = new HashSet<>();
    @Override
    public boolean register(Client client) {
        boolean contains = false;
        for (Client c : this.clients) {
            if (c.getDocument().equalsIgnoreCase(client.getDocument())) {
                contains = true;
                break;
            }
        }
        if (!contains) {
            this.clients.add(client);
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
}
