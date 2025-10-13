package ma.fstt.atelier1.services;

import java.util.List;

public interface Service<T>{
    T getClient();
    List<T> getAllClients();
    void addClient(T newClient);
    void updateClient(T newClient);
    void deleteClient(T newClient);
}
