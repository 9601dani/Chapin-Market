package com.danimo.chapin.market.daoImpl;

import com.danimo.chapin.market.conexion.Conexion;
import com.danimo.chapin.market.dao.BodegaDao;
import com.danimo.chapin.market.model.Bodega;

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
                        resultadoConsulta.getString("nombre"),
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
                        resultadoConsulta.getString("nombre"),
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
        String consulta = "INSERT INTO rycp.bodega (sucursal, nombre, cantidad) VALUES (?,?,?)";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setInt(1, bodega.getSucursal());
            statement.setString(2, bodega.getNombre());
            statement.setInt(3, bodega.getCantidad());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void actualizar(Bodega bodega) {
        String consulta = "UPDATE rycp.bodega SET cantidad=? WHERE sucursal=? AND nombre=?;";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setInt(1, bodega.getCantidad());
            statement.setInt(2, bodega.getSucursal());
            statement.setString(3, bodega.getNombre());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

    }
}
