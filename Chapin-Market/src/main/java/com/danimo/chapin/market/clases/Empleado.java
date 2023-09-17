package com.danimo.chapin.market.clases;

import com.danimo.chapin.market.enums.Rol;
import com.danimo.chapin.market.enums.Sucursal;

public class Empleado {
    private int id;
    private String nombre;
    private String apellido;
    private String username;
    private String password;
    private int no_caja;
    private Sucursal sucursal_id;
    private Rol rol_id;

    public Empleado(int id, String nombre, String apellido, String username, String password, int no_caja, Sucursal sucursal_id, Rol rol_id) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.no_caja = no_caja;
        this.sucursal_id = sucursal_id;
        this.rol_id = rol_id;
    }

    public Empleado(String nombre, String apellido, String username, String password, int no_caja, Sucursal sucursal_id, Rol rol_id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.no_caja = no_caja;
        this.sucursal_id = sucursal_id;
        this.rol_id = rol_id;
    }

    public Empleado(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNo_caja() {
        return no_caja;
    }

    public void setNo_caja(int no_caja) {
        this.no_caja = no_caja;
    }

    public Sucursal getSucursal_id() {
        return sucursal_id;
    }

    public void setSucursal_id(Sucursal sucursal_id) {
        this.sucursal_id = sucursal_id;
    }

    public Rol getRol_id() {
        return rol_id;
    }

    public void setRol_id(Rol rol_id) {
        this.rol_id = rol_id;
    }
}
