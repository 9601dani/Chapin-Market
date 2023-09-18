package com.danimo.chapin.market.dao;

import com.danimo.chapin.market.model.Empleado;

import java.util.ArrayList;

public interface CRUD <T> {
    ArrayList<T> obtenerTodos();
    T obtenerPorId(int id);
    void insertar(T t);
    void actualizar(T t);
    void eliminar(int id);
}
