package com.danimo.chapin.market.model;

public class ReporteClientesDinero {
    private Cliente cliente;
    private double dineroGastado;

    public ReporteClientesDinero(Cliente cliente, double dineroGastado) {
        this.cliente = cliente;
        this.dineroGastado = dineroGastado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getDineroGastado() {
        return dineroGastado;
    }

    public void setDineroGastado(double dineroGastado) {
        this.dineroGastado = dineroGastado;
    }
}
