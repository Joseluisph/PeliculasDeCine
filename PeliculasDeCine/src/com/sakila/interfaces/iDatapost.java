package com.sakila.interfaces;

import java.util.List;

public interface iDatapost<T> {
    boolean post(T entidad);              // Insertar
    T get(int id);                        // Buscar por ID
    List<T> get();                        // Listar todos
    boolean put(T entidad);              // Actualizar
    boolean delete(int id);              // Eliminar
}
