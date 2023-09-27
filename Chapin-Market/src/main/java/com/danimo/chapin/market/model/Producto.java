package com.danimo.chapin.market.model;

public class Producto {
    private int codigo_producto;
    private String nombre;
    private double precio;
    private String descripcion;
    private String marca;

    public Producto(int codigo_producto, String nombre, double precio, String descripcion, String marca) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.marca = marca;
    }

    public Producto(String nombre, double precio, String descripcion, String marca) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo_producto=" + codigo_producto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
