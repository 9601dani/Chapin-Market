package com.danimo.chapin.market.dao;

import com.danimo.chapin.market.model.Tarjeta;

public interface TarjetaDao extends CRUD<Tarjeta>{
    Tarjeta obtenerPorCliente(String nit);
    Boolean verificarExistenciaTarjeta(String nit);
}
