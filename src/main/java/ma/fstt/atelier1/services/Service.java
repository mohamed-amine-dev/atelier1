package ma.fstt.atelier1.services;

import java.sql.SQLException;
import java.util.List;

public interface Service<T>{
    T getOne(long id) throws SQLException;
    List<T> getAll();
    void add(T newClient);
    void update(T newClient);
    void delete(T newClient);
}
