package com.danimo.chapin.market.daoImpl;

import com.danimo.chapin.market.conexion.Conexion;
import com.danimo.chapin.market.dao.BodegaDao;
import com.danimo.chapin.market.model.Bodega;
import com.danimo.chapin.market.model.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BodegaDaoImpl implements BodegaDao {

    @Override
    public ArrayList<Bodega> obtenerTodos() {
        String consulta = "SELECT * FROM rycp.bodega;";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            ArrayList<Bodega> bodegas = new ArrayList<>();
            while (resultadoConsulta.next()){
                Bodega bodega = new Bodega(
                        resultadoConsulta.getInt("sucursal"),
                        resultadoConsulta.getInt("producto"),
                        resultadoConsulta.getInt("cantidad")
                );
                bodegas.add(bodega);
            }
            return bodegas;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Bodega obtenerPorId(int id) {
        String consulta = "SELECT * FROM rycp.bodega where sucursal=" + id;
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            if (resultadoConsulta.next()) {
                Bodega bodega = new Bodega(
                        resultadoConsulta.getInt("sucursal"),
                        resultadoConsulta.getInt("producto"),
                        resultadoConsulta.getInt("cantidad")
                );
                return bodega;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertar(Bodega bodega) {
        String consulta = "INSERT INTO rycp.bodega (sucursal, producto, cantidad) VALUES (?,?,?)";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setInt(1, bodega.getSucursal());
            statement.setInt(2, bodega.getProducto());
            statement.setInt(3, bodega.getCantidad());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void actualizar(Bodega bodega) {
        String consulta = "UPDATE rycp.bodega SET cantidad=? WHERE sucursal=? AND producto=?;";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setInt(1, bodega.getCantidad());
            statement.setInt(2, bodega.getSucursal());
            statement.setInt(3, bodega.getProducto());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Bodega obtenerProducto(int sucursal, int producto) {
        String consutla = "SELECT * FROM rycp.bodega WHERE sucursal = ? AND producto = ?";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consutla);
            statement.setInt(1, sucursal);
            statement.setInt(2, producto);
            ResultSet resultadoConsulta = statement.executeQuery();
            if (resultadoConsulta.next()) {
                Bodega bodega = new Bodega(
                        resultadoConsulta.getInt("sucursal"),
                        resultadoConsulta.getInt("producto"),
                        resultadoConsulta.getInt("cantidad")
                );
                return bodega;
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public Producto obtenerProductoAdmin(String name_producto) {
        String consulta = "SELECT * FROM rycp.producto where nombre = ?";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setString(1, name_producto);
            ResultSet resultadoConsulta = statement.executeQuery();
            if (resultadoConsulta.next()) {
                Producto producto = new Producto(
                        resultadoConsulta.getInt("codigo_producto"),
                        resultadoConsulta.getString("nombre"),
                        resultadoConsulta.getDouble("precio"),
                        resultadoConsulta.getString("descripcion"),
                        resultadoConsulta.getString("marca")
                );
                return producto;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Bodega> obtenerProductosSucursal(int sucursal) {
        String consulta = "SELECT * FROM rycp.bodega where sucursal=" + sucursal;
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            ArrayList<Bodega> bodegas = new ArrayList<>();
            while (resultadoConsulta.next()){
                Bodega bodega = new Bodega(
                        resultadoConsulta.getInt("sucursal"),
                        resultadoConsulta.getInt("producto"),
                        resultadoConsulta.getInt("cantidad")
                );
                bodegas.add(bodega);
            }
            return bodegas;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
