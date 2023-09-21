package com.danimo.chapin.market.daoImpl;

import com.danimo.chapin.market.conexion.Conexion;
import com.danimo.chapin.market.dao.EstanteriaDao;
import com.danimo.chapin.market.model.Estanteria;
import com.danimo.chapin.market.model.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EstanteriaDaoImpl implements EstanteriaDao {
    @Override
    public ArrayList<Estanteria> obtenerTodos() {
        String consulta = "SELECT * FROM rycp.estanteria;";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            ArrayList<Estanteria> estanterias = new ArrayList<>();
            while (resultadoConsulta.next()){
                Estanteria estanteria = new Estanteria(
                        resultadoConsulta.getInt("sucursal"),
                        resultadoConsulta.getInt("producto"),
                        resultadoConsulta.getInt("cantidad")
                );
                estanterias.add(estanteria);
            }
            return estanterias;


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Estanteria obtenerPorId(int id) {
        return null;
    }

    @Override
    public void insertar(Estanteria estanteria) {

    }

    @Override
    public void actualizar(Estanteria estanteria) {

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public ArrayList<Estanteria> obtenerProductosEstanterias(int sucursal) {
        String consulta = "SELECT * FROM rycp.estanteria where sucursal=" + sucursal;
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            ArrayList<Estanteria> estanterias = new ArrayList<>();
            while (resultadoConsulta.next()) {
                Estanteria estanteria = new Estanteria(
                        resultadoConsulta.getInt("sucursal"),
                        resultadoConsulta.getInt("producto"),
                        resultadoConsulta.getInt("cantidad")
                );
                estanterias.add(estanteria);
            }
            return estanterias;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Producto obtenerProductoAdmin(String name_producto) {
        String consulta = "SELECT * FROM rycp.producto where nombre='" + name_producto + "'";
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
