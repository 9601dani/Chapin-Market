package com.danimo.chapin.market.model;

public class Cliente {
    private String nit;
    private String nombre;
    private String direccion;
    private int no_puntos;

    public Cliente(String nit, String nombre, String direccion, int no_puntos) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.no_puntos = no_puntos;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNo_puntos() {
        return no_puntos;
    }

    public void setNo_puntos(int no_puntos) {
        this.no_puntos = no_puntos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nit='" + nit + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", no_puntos=" + no_puntos +
                '}';
    }
}