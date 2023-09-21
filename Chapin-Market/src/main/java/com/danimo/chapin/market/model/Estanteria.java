package com.danimo.chapin.market.model;

public class Estanteria {
    private int sucursal;
    private int producto;
    private int cantidad;

    public Estanteria(int sucursal, int producto, int cantidad) {
        this.sucursal = sucursal;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Estanteria(int sucursal, int producto) {
        this.sucursal = sucursal;
        this.producto = producto;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
