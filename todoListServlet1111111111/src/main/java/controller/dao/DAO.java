package controller.dao;

import java.util.Set;

public interface DAO<T> {
    boolean add(T value);
    boolean delete(T value);
    Set<T> getAll();

    boolean deleteByName(String name);

    T getById(int id);

    boolean deleteById(int id);
}
