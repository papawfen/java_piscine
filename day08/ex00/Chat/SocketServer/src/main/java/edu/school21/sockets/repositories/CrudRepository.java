package edu.school21.sockets.repositories;

import java.util.*;
@SuppressWarnings("unused")
public interface CrudRepository<T> {
    T findById(Long id);
    List<T> findAll();
    void save (T en);
    void update (T en);
    void delete(Long id);

}
