package com.danimo.chapin.market.model;

public class Bodega {
   private int sucursal;
    private String nombre;
    private int cantidad;

    public Bodega(int sucursal, String nombre, int cantidad) {
        this.sucursal = sucursal;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Bodega(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
