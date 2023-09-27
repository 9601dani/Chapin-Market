package com.danimo.chapin.market.model;

public class DetalleVenta {
    private int codigo_detalle_venta;
    private int codigo_venta;
    private int codigo_producto;
    private int cantidad_producto;

    public DetalleVenta(int codigo_detalle_venta, int codigo_venta, int codigo_producto, int cantidad_producto) {
        this.codigo_detalle_venta = codigo_detalle_venta;
        this.codigo_venta = codigo_venta;
        this.codigo_producto = codigo_producto;
        this.cantidad_producto = cantidad_producto;
    }

    public DetalleVenta(int codigo_venta, int codigo_producto, int cantidad_producto) {
        this.codigo_venta = codigo_venta;
        this.codigo_producto = codigo_producto;
        this.cantidad_producto = cantidad_producto;
    }

    public int getCodigo_detalle_venta() {
        return codigo_detalle_venta;
    }

    public void setCodigo_detalle_venta(int codigo_detalle_venta) {
        this.codigo_detalle_venta = codigo_detalle_venta;
    }

    public int getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(int codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }
}
