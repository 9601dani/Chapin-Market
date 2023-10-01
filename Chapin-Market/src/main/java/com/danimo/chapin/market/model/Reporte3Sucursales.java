package com.danimo.chapin.market.model;

public class Reporte3Sucursales {
    private String sucursal;
    private double total;

    public Reporte3Sucursales(String sucursal, double total) {
        this.sucursal = sucursal;
        this.total = total;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
