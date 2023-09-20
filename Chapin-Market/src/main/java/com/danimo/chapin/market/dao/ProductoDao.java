package com.danimo.chapin.market.dao;

import com.danimo.chapin.market.model.Producto;

import java.util.ArrayList;

public interface ProductoDao extends CRUD<Producto> {
    // aqui van metodos que puede hacer un producto, pero no los demas usuarios
    public ArrayList<String> obtenerNombres();
}
