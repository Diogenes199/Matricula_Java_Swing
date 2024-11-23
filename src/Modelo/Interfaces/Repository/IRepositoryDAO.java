package Modelo.Interfaces.Repository;

import java.util.List;

public interface IRepositoryDAO <T>{
    
    List<T> findAll();
    void create(T t);
    void update(T t);
    void delete(String id);
    T findById(String id);    
}
