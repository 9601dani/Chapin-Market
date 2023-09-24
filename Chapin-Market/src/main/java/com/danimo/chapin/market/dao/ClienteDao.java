package com.danimo.chapin.market.dao;

import com.danimo.chapin.market.model.Cliente;

public interface ClienteDao extends CRUD<Cliente>{
    void actualizarPuntos(int nit, int puntos);
    Cliente obtenerPorNit(String nit);
}
