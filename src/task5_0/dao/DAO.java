package task5_0.dao;

import java.util.List;

public interface DAO<T> {
    boolean save(T t);

    List<T> getAllOfFile();
}
