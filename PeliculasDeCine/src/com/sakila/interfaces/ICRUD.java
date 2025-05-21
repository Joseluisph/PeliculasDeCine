package com.sakila.interfaces;

import java.util.List;

public interface ICRUD<T> {
    void create(T obj);
    T read(int id);
    List<T> readAll();
    void update(T obj);
    void delete(int id);
}
