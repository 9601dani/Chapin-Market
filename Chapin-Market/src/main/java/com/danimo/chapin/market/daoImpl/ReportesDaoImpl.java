package com.danimo.chapin.market.daoImpl;

import com.danimo.chapin.market.conexion.Conexion;
import com.danimo.chapin.market.dao.ReportesDao;
import com.danimo.chapin.market.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReportesDaoImpl implements ReportesDao {


    @Override
    public ArrayList<ReporteDescuento> obtenerReporteDescuento(String fechaInicio, String fechaFin) {
        String consulta = "SELECT c.nombre, f.fecha, f.descuento, e.nombre AS nombre_empleado, s.nombre as nombre_sucursal, f.codigo_venta FROM rycp.venta f\n" +
                "INNER JOIN rycc.cliente c ON f.nit_cliente = c.nit_cliente\n" +
                "INNER JOIN ryce.empleado e ON f.codigo_empleado = e.codigo_empleado\n" +
                "INNER JOIN ryce.sucursal s ON e.codigo_sucursal = s.codigo_sucursal\n" +
                "WHERE f.descuento > 0 AND f.fecha BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "';";
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            ArrayList<ReporteDescuento> reporteDescuentos = new ArrayList<>();
           while (resultadoConsulta.next()){
               ReporteDescuento reporteDescuento = new ReporteDescuento(
                       resultadoConsulta.getString("nombre"),
                       LocalDate.parse(resultadoConsulta.getString("fecha"), formatter),
                       resultadoConsulta.getDouble("descuento"),
                       resultadoConsulta.getString("nombre_empleado"),
                       resultadoConsulta.getString("nombre_sucursal"),
                       resultadoConsulta.getInt("codigo_venta")
               );
               reporteDescuentos.add(reporteDescuento);
           }
            return reporteDescuentos;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Venta> top10Ventas(String fechaInicio, String fechaFin) {
        String consulta = "SELECT * FROM rycp.venta WHERE fecha BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "' ORDER BY total DESC LIMIT 10;";
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            ArrayList<Venta> ventas = new ArrayList<>();
            while (resultadoConsulta.next()){
                Venta venta = new Venta(
                        resultadoConsulta.getInt("codigo_venta"),
                        LocalDate.parse(resultadoConsulta.getString("fecha"), formatter),
                        resultadoConsulta.getDouble("subtotal"),
                        resultadoConsulta.getDouble("descuento"),
                        resultadoConsulta.getDouble("total"),
                        resultadoConsulta.getString("nit_cliente"),
                        resultadoConsulta.getInt("codigo_empleado")
                );
                ventas.add(venta);
            }
            return ventas;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Reporte3Sucursales> top3Sucursales() {
        String consulta="SELECT s.nombre, SUM(v.total) AS total FROM rycp.venta v\n" +
                "INNER JOIN ryce.empleado e ON v.codigo_empleado = e.codigo_empleado\n" +
                "INNER JOIN ryce.sucursal s ON e.codigo_sucursal = s.codigo_sucursal\n" +
                "GROUP BY s.nombre\n" +
                "ORDER BY total DESC\n" +
                "LIMIT 3;";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            ArrayList<Reporte3Sucursales> reporte3Sucursales = new ArrayList<>();
            while (resultadoConsulta.next()){
                Reporte3Sucursales reporte3Sucursal = new Reporte3Sucursales(
                        resultadoConsulta.getString("nombre"),
                        resultadoConsulta.getDouble("total")
                );
                reporte3Sucursales.add(reporte3Sucursal);
            }
            return reporte3Sucursales;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ReporteArticulosMasVendidos> top10ArticulosMasVendidos() {
        String consulta="SELECT p.codigo_producto, p.nombre, p.precio, p.descripcion, p.marca, SUM(d.cantidad) AS cantidad FROM rycp.detalleventa d\n" +
                "INNER JOIN rycp.producto p ON d.producto = p.codigo_producto\n" +
                "GROUP BY p.codigo_producto\n" +
                "ORDER BY cantidad DESC\n" +
                "LIMIT 10;";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            ArrayList<ReporteArticulosMasVendidos> reporteArticulosMasVendidos = new ArrayList<>();
            while (resultadoConsulta.next()){
                ReporteArticulosMasVendidos reporteArticulosMasVendido = new ReporteArticulosMasVendidos(
                        new Producto(
                                resultadoConsulta.getInt("codigo_producto"),
                                resultadoConsulta.getString("nombre"),
                                resultadoConsulta.getDouble("precio"),
                                resultadoConsulta.getString("descripcion"),
                                resultadoConsulta.getString("marca")),
                        resultadoConsulta.getInt("cantidad")
                );
                reporteArticulosMasVendidos.add(reporteArticulosMasVendido);
            }
            return reporteArticulosMasVendidos;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ReporteClientesDinero> top10Clientes() {
        String consulta="SELECT c.nit_cliente, c.nombre, SUM(v.total) AS total FROM rycp.venta v\n" +
                "INNER JOIN rycc.cliente c ON v.nit_cliente = c.nit_cliente\n" +
                "GROUP BY c.nit_cliente\n" +
                "ORDER BY total DESC\n" +
                "LIMIT 10;";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            ArrayList<ReporteClientesDinero> reporteClientesDinero = new ArrayList<>();
            while (resultadoConsulta.next()){
                ReporteClientesDinero reporteClienteDinero = new ReporteClientesDinero(
                                    new ClienteDaoImpl().obtenerPorNit(resultadoConsulta.getString("nit_cliente")),
                            resultadoConsulta.getDouble("total"
                ));
                reporteClientesDinero.add(reporteClienteDinero);
            }
            return reporteClientesDinero;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
