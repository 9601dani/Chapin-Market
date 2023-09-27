package com.danimo.chapin.market.model;

import com.danimo.chapin.market.enums.CategoriaTarjeta;

public class Tarjeta {
    private String nit_cliente;
    private CategoriaTarjeta codigo_categoria;
    private Double total_gastado;

    public Tarjeta(String nit_cliente, CategoriaTarjeta codigo_categoria, Double total_gastado) {
        this.nit_cliente = nit_cliente;
        this.codigo_categoria = codigo_categoria;
        this.total_gastado = total_gastado;
    }

    public String getNit_cliente() {
        return nit_cliente;
    }

    public void setNit_cliente(String nit_cliente) {
        this.nit_cliente = nit_cliente;
    }

    public CategoriaTarjeta getCodigo_categoria() {
        return codigo_categoria;
    }

    public void setCodigo_categoria(CategoriaTarjeta codigo_categoria) {
        this.codigo_categoria = codigo_categoria;
    }

    public Double getTotal_gastado() {
        return total_gastado;
    }

    public void setTotal_gastado(Double total_gastado) {
        this.total_gastado = total_gastado;
    }
}
