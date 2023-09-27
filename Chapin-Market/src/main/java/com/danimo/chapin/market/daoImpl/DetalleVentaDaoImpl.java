package com.danimo.chapin.market.daoImpl;

import com.danimo.chapin.market.conexion.Conexion;
import com.danimo.chapin.market.dao.DetalleVentaDao;
import com.danimo.chapin.market.model.DetalleVenta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class DetalleVentaDaoImpl implements DetalleVentaDao {
    @Override
    public ArrayList<DetalleVenta> obtenerTodos() {
        return null;
    }

    @Override
    public DetalleVenta obtenerPorId(int id) {
        String consulta = "SELECT * FROM rycp.detalle_venta where codigo_detalle_venta=" + id;
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            if (resultadoConsulta.next()) {
                DetalleVenta detalleVenta = new DetalleVenta(
                        resultadoConsulta.getInt("codigo_detalle_venta"),
                        resultadoConsulta.getInt("codigo_venta"),
                        resultadoConsulta.getInt("codigo_producto"),
                        resultadoConsulta.getInt("cantidad_producto")
                );
                return detalleVenta;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertar(DetalleVenta detalleVenta) {
        String consulta = "INSERT INTO rycp.detalleventa (codigo_venta, producto, cantidad) VALUES(?,?,?)";
        System.out.println("Insertando detalle venta  "+detalleVenta.getCodigo_venta());
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setInt(1, detalleVenta.getCodigo_venta());
            statement.setInt(2, detalleVenta.getCodigo_producto());
            statement.setInt(3, detalleVenta.getCantidad_producto());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void actualizar(DetalleVenta detalleVenta) {

    }

    @Override
    public void eliminar(int id) {

    }
}
