package com.danimo.chapin.market.model;

import java.sql.Date;

public class Venta {
    private int codigo_venta;
    private Date fecha;
    private double subtotal;
    private double descuento;
    private double total;
    private String nit_cliente;
    private int codigo_empleado;

    public Venta(int codigo_venta, Date fecha, double subtotal, double descuento, double total, String nit_cliente, int codigo_empleado) {
        this.codigo_venta = codigo_venta;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.total = total;
        this.nit_cliente = nit_cliente;
        this.codigo_empleado = codigo_empleado;
    }

    public Venta(Date fecha, double subtotal, double descuento, double total, String nit_cliente, int codigo_empleado) {
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.total = total;
        this.nit_cliente = nit_cliente;
        this.codigo_empleado = codigo_empleado;
    }

    public int getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(int codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNit_cliente() {
        return nit_cliente;
    }

    public void setNit_cliente(String nit_cliente) {
        this.nit_cliente = nit_cliente;
    }

    public int getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(int codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }
}
