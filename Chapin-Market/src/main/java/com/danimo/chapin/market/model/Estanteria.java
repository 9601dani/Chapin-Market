package com.danimo.chapin.market.model;

public class Estanteria {
    private int sucursal;
    private int producto;
    private int cantidad;
    private int no_pasillo;

    public Estanteria(int sucursal, int producto, int cantidad, int no_pasillo) {
        this.sucursal = sucursal;
        this.producto = producto;
        this.cantidad = cantidad;
        this.no_pasillo = no_pasillo;
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

    public int getNo_pasillo() {
        return no_pasillo;
    }

    public void setNo_pasillo(int no_pasillo) {
        this.no_pasillo = no_pasillo;
    }
}
