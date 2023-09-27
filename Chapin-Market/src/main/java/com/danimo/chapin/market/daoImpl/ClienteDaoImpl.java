package com.danimo.chapin.market.daoImpl;

import com.danimo.chapin.market.conexion.Conexion;
import com.danimo.chapin.market.dao.ClienteDao;
import com.danimo.chapin.market.model.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDaoImpl implements ClienteDao {
    @Override
    public ArrayList<Cliente> obtenerTodos() {
        String consulta = "SELECT * FROM rycc.cliente";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            ArrayList<Cliente> clientes = new ArrayList<>();
            while (resultadoConsulta.next()){
                Cliente cliente = new Cliente(
                        resultadoConsulta.getString("nit_cliente"),
                        resultadoConsulta.getString("nombre"),
                        resultadoConsulta.getString("direccion"),
                        resultadoConsulta.getInt("no_puntos")
                );
                clientes.add(cliente);
            }
            return clientes;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Cliente obtenerPorId(int id) {
        String consulta = "SELECT * FROM rycc.cliente WHERE nit_cliente='" + id + "'";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            if (resultadoConsulta.next()) {
                Cliente cliente = new Cliente(
                        resultadoConsulta.getString("nit_cliente"),
                        resultadoConsulta.getString("nombre"),
                        resultadoConsulta.getString("direccion"),
                        resultadoConsulta.getInt("no_puntos")
                );
                return cliente;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertar(Cliente cliente) {
        String consulta = "INSERT INTO rycc.cliente (nit_cliente, nombre, direccion, no_puntos) VALUES(?,?,?,?)";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setString(1, cliente.getNit());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getDireccion());
            statement.setInt(4, cliente.getNo_puntos());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Cliente cliente) {
        String consulta = "UPDATE rycc.cliente SET nombre=?, direccion=?, no_puntos=? WHERE nit_cliente=?";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getDireccion());
            statement.setInt(3, cliente.getNo_puntos());
            statement.setString(4, cliente.getNit());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public void actualizarPuntos(String nit, int puntos) {
        String consulta = "UPDATE rycc.cliente SET no_puntos=? WHERE nit_cliente=?";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setInt(1, puntos);
            statement.setString(2, nit);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Cliente obtenerPorNit(String nit) {
        String consulta = "SELECT * FROM rycc.cliente WHERE nit_cliente='" + nit + "'";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            if (resultadoConsulta.next()) {
                Cliente cliente = new Cliente(
                        resultadoConsulta.getString("nit_cliente"),
                        resultadoConsulta.getString("nombre"),
                        resultadoConsulta.getString("direccion"),
                        resultadoConsulta.getInt("no_puntos")
                );
                return cliente;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
