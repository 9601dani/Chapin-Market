package com.danimo.chapin.market.daoImpl;

import com.danimo.chapin.market.conexion.Conexion;
import com.danimo.chapin.market.dao.VentaDao;
import com.danimo.chapin.market.model.Venta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VentaDaoImpl implements VentaDao {
    @Override
    public ArrayList<Venta> obtenerTodos() {
        String consulta = "SELECT * FROM rycp.venta;";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            ArrayList<Venta> ventas = new ArrayList<>();
            while (resultadoConsulta.next()){
                Venta venta = new Venta(
                        resultadoConsulta.getInt("codigo_venta"),
                        resultadoConsulta.getDate("fecha_venta"),
                        resultadoConsulta.getDouble("subtotal"),
                        resultadoConsulta.getDouble("Descuento"),
                        resultadoConsulta.getDouble("total"),
                        resultadoConsulta.getString("nit_cliente"),
                        resultadoConsulta.getInt("Codigo_empleado")
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
    public Venta obtenerPorId(int id) {
        String consulta = "SELECT * FROM rycp.venta where codigo_venta='" + id + "'";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            if (resultadoConsulta.next()) {
                Venta venta = new Venta(
                        resultadoConsulta.getInt("codigo_venta"),
                        resultadoConsulta.getDate("fecha_venta"),
                        resultadoConsulta.getDouble("subtotal"),
                        resultadoConsulta.getDouble("Descuento"),
                        resultadoConsulta.getDouble("total"),
                        resultadoConsulta.getString("nit_cliente"),
                        resultadoConsulta.getInt("Codigo_empleado")
                );
                return venta;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertar(Venta venta) {
        String consulta = "INSERT INTO rycp.venta (fecha_venta, subtotal, descuento,total,nit_cliente,codigo_empleado) VALUES (?, ?,?,?,?,?);";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setDate(1, venta.getFecha());
            statement.setDouble(2, venta.getSubtotal());
            statement.setDouble(3, venta.getDescuento());
            statement.setDouble(4, venta.getTotal());
            statement.setString(5, venta.getNit_cliente());
            statement.setInt(6, venta.getCodigo_empleado());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void actualizar(Venta venta) {
        String consulta = "UPDATE rycp.venta SET fecha_venta = ?, subtotal = ?, descuento = ?, total=?, nit_cliente=?, codigo_empleado=? WHERE codigo_venta = ?;";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setDate(1, venta.getFecha());
            statement.setDouble(2, venta.getSubtotal());
            statement.setDouble(3, venta.getDescuento());
            statement.setDouble(4, venta.getTotal());
            statement.setString(5, venta.getNit_cliente());
            statement.setInt(6, venta.getCodigo_empleado());
            statement.setInt(7, venta.getCodigo_venta());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

    }
}
