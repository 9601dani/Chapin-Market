package com.danimo.chapin.market.dao;

import com.danimo.chapin.market.model.Bodega;
import com.danimo.chapin.market.model.Estanteria;
import com.danimo.chapin.market.model.Producto;

import java.util.ArrayList;

public interface EstanteriaDao extends CRUD<Estanteria> {
    ArrayList<Estanteria> obtenerProductosEstanterias(int sucursal);
    Producto obtenerProductoAdmin(String name_producto);

}
