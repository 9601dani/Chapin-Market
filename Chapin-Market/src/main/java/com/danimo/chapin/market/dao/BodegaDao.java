package com.danimo.chapin.market.dao;

import com.danimo.chapin.market.model.Bodega;
import com.danimo.chapin.market.model.Producto;

import java.util.ArrayList;

public interface BodegaDao extends CRUD<Bodega>{
    Bodega obtenerProducto(int sucursal, int producto);

    Producto obtenerProductoAdmin(String name_producto);

    ArrayList<Bodega> obtenerProductosSucursal(int sucursal);


}
