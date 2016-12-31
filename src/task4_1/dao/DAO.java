package task4_1.dao;

import java.util.List;

public interface DAO<T> {

    boolean save(T t);

    boolean delete(T t);

    T update(T t, int index);

    T findById(long id);

    List<T> getAll();



}
