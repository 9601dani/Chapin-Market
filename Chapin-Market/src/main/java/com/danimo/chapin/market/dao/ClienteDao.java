package com.danimo.chapin.market.dao;

import com.danimo.chapin.market.model.Cliente;

public interface ClienteDao extends CRUD<Cliente>{
    void actualizarPuntos(String nit, int puntos);
    Cliente obtenerPorNit(String nit);

}
