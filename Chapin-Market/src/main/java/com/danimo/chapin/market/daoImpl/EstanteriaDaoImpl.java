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
                        resultadoConsulta.getInt("cantidad"),
                        resultadoConsulta.getInt("no_pasillo")
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
        String consulta = "SELECT * FROM rycp.estanteria where sucursal=" + id;
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            if (resultadoConsulta.next()) {
                Estanteria estanteria = new Estanteria(
                        resultadoConsulta.getInt("sucursal"),
                        resultadoConsulta.getInt("producto"),
                        resultadoConsulta.getInt("cantidad"),
                        resultadoConsulta.getInt("no_pasillo")
                );
                return estanteria;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertar(Estanteria estanteria) {
        String consulta = "INSERT INTO rycp.estanteria (sucursal, producto, cantidad, no_pasillo) VALUES (?,?,?,?)";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setInt(1, estanteria.getSucursal());
            statement.setInt(2, estanteria.getProducto());
            statement.setInt(3, estanteria.getCantidad());
            statement.setInt(4, estanteria.getNo_pasillo());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void actualizar(Estanteria estanteria) {
        String consulta = "UPDATE rycp.estanteria SET cantidad=? WHERE sucursal=? and producto=?";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setInt(1, estanteria.getCantidad());
            statement.setInt(2, estanteria.getSucursal());
            statement.setInt(3, estanteria.getProducto());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(int id) {
        String consulta = "DELETE FROM rycp.estanteria WHERE sucursal=? and producto=?";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

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
                        resultadoConsulta.getInt("cantidad"),
                        resultadoConsulta.getInt("no_pasillo")
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

    @Override
    public Estanteria obtenerProducto(int sucursal, int producto) {
        String consulta = "SELECT * FROM rycp.estanteria where sucursal=" + sucursal + " and producto=" + producto;
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            if (resultadoConsulta.next()) {
                Estanteria estanteria = new Estanteria(
                        resultadoConsulta.getInt("sucursal"),
                        resultadoConsulta.getInt("producto"),
                        resultadoConsulta.getInt("cantidad"),
                        resultadoConsulta.getInt("no_pasillo")
                );
                return estanteria;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<String> obtenerProductosSugeridos(int sucursal, String produc) {
        String consulta = "SELECT * FROM rycp.estanteria where sucursal=" + sucursal;
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            ArrayList<Integer> productos = new ArrayList<>();
            while (resultadoConsulta.next()){
                int producto = resultadoConsulta.getInt("producto");
                productos.add(producto);
            }
            //TODO aqui obtendre los nombres de los productos dado mi array "productos" tiene el codigo de los productos
            ArrayList<String> nombres = new ArrayList<>();
            for(int producto: productos){
                String consulta2 = "SELECT nombre FROM rycp.producto where nombre LIKE ? ";
                PreparedStatement statement2 = Conexion.obtenerConexion().prepareStatement(consulta2);
                statement2.setString(1, "%" + produc + "%");
                ResultSet resultadoConsulta2 = statement2.executeQuery();
                if (resultadoConsulta2.next()) {
                    String nombre = resultadoConsulta2.getString("nombre");
                    nombres.add(nombre);
                }
            }
            return nombres;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizarCantidad(int sucursal, int producto, int cantidad) {
        String consulta = "UPDATE rycp.estanteria SET cantidad=? WHERE sucursal=? and producto=?";
        try{
            Estanteria estan= this.obtenerProducto(sucursal, producto);
            estan.getCantidad();
            int total= estan.getCantidad() - cantidad;
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setInt(1, total);
            statement.setInt(2, sucursal);
            statement.setInt(3, producto);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
