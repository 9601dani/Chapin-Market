package com.danimo.chapin.market.model;

public class Producto {
    private int codigo_producto;
    private String nombre;
    private double precio;

    public Producto(int codigo_producto, String nombre, double precio) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

}
