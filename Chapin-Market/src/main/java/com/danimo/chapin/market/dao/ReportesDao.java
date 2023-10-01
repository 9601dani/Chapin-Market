package com.danimo.chapin.market.dao;

import com.danimo.chapin.market.enums.Sucursal;
import com.danimo.chapin.market.model.*;

import java.util.ArrayList;

public interface ReportesDao {
    ArrayList<ReporteDescuento> obtenerReporteDescuento(String fechaInicio, String fechaFin);
    ArrayList<Venta> top10Ventas(String fechaInicio, String fechaFin);
    ArrayList<Reporte3Sucursales> top3Sucursales();
    ArrayList<ReporteArticulosMasVendidos> top10ArticulosMasVendidos();
    ArrayList<ReporteClientesDinero> top10Clientes();
}
