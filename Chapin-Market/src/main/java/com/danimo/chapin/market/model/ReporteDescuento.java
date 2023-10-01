package com.danimo.chapin.market.model;

import java.time.LocalDate;

public class ReporteDescuento {
    private String nombre_cliente;
    private LocalDate fecha;
    private double monto_descuento;
    private String nombre_empleado;
    private String sucursal;
    private int no_factura;

    public ReporteDescuento(String nombre_cliente, LocalDate fecha, double monto_descuento, String nombre_empleado, String sucursal, int no_factura) {
        this.nombre_cliente = nombre_cliente;
        this.fecha = fecha;
        this.monto_descuento = monto_descuento;
        this.nombre_empleado = nombre_empleado;
        this.sucursal = sucursal;
        this.no_factura = no_factura;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMonto_descuento() {
        return monto_descuento;
    }

    public void setMonto_descuento(double monto_descuento) {
        this.monto_descuento = monto_descuento;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getNo_factura() {
        return no_factura;
    }

    public void setNo_factura(int no_factura) {
        this.no_factura = no_factura;
    }
}
