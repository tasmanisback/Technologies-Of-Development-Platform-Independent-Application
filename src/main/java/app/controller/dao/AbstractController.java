package app.controller.dao;

import java.sql.SQLException;
import java.util.List;

public interface AbstractController <E,K>{
    public List<E> getAll() throws Exception;
    public E getEntityById(K id) throws SQLException;
    public void update(E entity) throws SQLException;
    public void delete(K id) throws SQLException;
    public void create(E entity) throws SQLException;
}
