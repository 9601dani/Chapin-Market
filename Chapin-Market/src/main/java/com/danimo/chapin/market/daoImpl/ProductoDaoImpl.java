package com.danimo.chapin.market.daoImpl;

import com.danimo.chapin.market.conexion.Conexion;
import com.danimo.chapin.market.dao.ProductoDao;
import com.danimo.chapin.market.model.Producto;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoDaoImpl implements ProductoDao {


    @Override
    public ArrayList<Producto> obtenerTodos() {
        String consulta = "SELECT * FROM rycp.producto;";
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            ArrayList<Producto> productos = new ArrayList<>();
            while (resultadoConsulta.next()) {
                Producto producto = new Producto(
                        resultadoConsulta.getInt("codigo_producto"),
                        resultadoConsulta.getString("nombre"),
                        resultadoConsulta.getDouble("precio"),
                        resultadoConsulta.getString("descripcion"),
                        resultadoConsulta.getString("marca")
                );
                productos.add(producto);
            }
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Producto obtenerPorId(int id) {
        //TODO: obtener producto por id ordenados por el codigo de producto
        String consulta = "SELECT * FROM rycp.producto where codigo_producto=" + id;
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
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
    public void insertar(Producto producto) {
        String consulta = "INSERT INTO rycp.producto (nombre, precio, descripcion,marca) VALUES (?, ?,?,?);";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setString(1, producto.getNombre());
            statement.setDouble(2, producto.getPrecio());
            statement.setString(3, producto.getDescripcion());
            statement.setString(4, producto.getMarca());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto guardado exitosamente");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void actualizar(Producto producto) {
        String consulta = "UPDATE rycp.producto SET nombre = ?, precio = ?, descripcion = ?, marca=? WHERE codigo_producto = ?;";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setString(1, producto.getNombre());
            statement.setDouble(2, producto.getPrecio());
            statement.setString(3, producto.getDescripcion());
            statement.setString(4, producto.getMarca());
            statement.setInt(5, producto.getCodigo_producto());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public ArrayList<String> obtenerNombres() {
        String consulta = "SELECT nombre FROM rycp.producto;";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            ArrayList<String> nombres = new ArrayList<>();
            while (resultadoConsulta.next()) {
                nombres.add(resultadoConsulta.getString("nombre"));
            }
            return nombres;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Producto obtenerPorNombre(String nombre) {
        String consulta = "SELECT * FROM rycp.producto where nombre='" + nombre + "'";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
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
}
