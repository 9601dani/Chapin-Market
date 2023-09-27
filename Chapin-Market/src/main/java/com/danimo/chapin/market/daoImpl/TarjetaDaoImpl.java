package com.danimo.chapin.market.daoImpl;

import com.danimo.chapin.market.conexion.Conexion;
import com.danimo.chapin.market.dao.TarjetaDao;
import com.danimo.chapin.market.enums.CategoriaTarjeta;
import com.danimo.chapin.market.model.Tarjeta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.danimo.chapin.market.enums.CategoriaTarjeta.getCategoriaTarjeta;
import static com.danimo.chapin.market.enums.CategoriaTarjeta.getIdCategoriaTarjetaInt;

public class TarjetaDaoImpl implements TarjetaDao {
    @Override
    public ArrayList<Tarjeta> obtenerTodos() {
        String consulta = "SELECT * FROM rycc.tarjetapuntos";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            ArrayList<Tarjeta> tarjetas = new ArrayList<>();
            while (resultadoConsulta.next()){
                Tarjeta tarjeta = new Tarjeta(
                        resultadoConsulta.getString("nit_cliente"),
                        getCategoriaTarjeta(resultadoConsulta.getInt("codigo_categoria")),
                        resultadoConsulta.getDouble("total_gastado")
                );
                tarjetas.add(tarjeta);
            }
            return tarjetas;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Tarjeta obtenerPorId(int id) {
        return null;
    }

    @Override
    public void insertar(Tarjeta tarjeta) {
        String consulta = "INSERT INTO rycc.tarjetapuntos (nit_cliente, codigo_categoria, total_gastado) VALUES(?,?,?)";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setString(1, tarjeta.getNit_cliente());
            statement.setInt(2, getIdCategoriaTarjetaInt(tarjeta.getCodigo_categoria()));
            statement.setDouble(3, tarjeta.getTotal_gastado());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Tarjeta tarjeta) {
        String consulta = "UPDATE rycc.tarjetapuntos SET codigo_categoria=?, total_gastado=? WHERE nit_cliente=?";
        //TODO: verifico el gasto, para cambiar de tipo la tarejta del cliente
        if(tarjeta.getTotal_gastado()>=10000 && tarjeta.getTotal_gastado()<20000){
            tarjeta.setCodigo_categoria(CategoriaTarjeta.ORO);
        }else if(tarjeta.getTotal_gastado()>=20000 && tarjeta.getTotal_gastado()<30000){
            tarjeta.setCodigo_categoria(CategoriaTarjeta.PLATINO);
        }else if(tarjeta.getTotal_gastado()>=30000){
            tarjeta.setCodigo_categoria(CategoriaTarjeta.DIAMANTE);
        }
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setInt(1, getIdCategoriaTarjetaInt(tarjeta.getCodigo_categoria()));
            statement.setDouble(2, tarjeta.getTotal_gastado());
            statement.setString(3, tarjeta.getNit_cliente());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Tarjeta obtenerPorCliente(String nit) {
        String consulta = "SELECT * FROM rycc.tarjetapuntos WHERE nit_cliente='" + nit + "'";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            if (resultadoConsulta.next()) {
                Tarjeta tarjeta = new Tarjeta(
                        resultadoConsulta.getString("nit_cliente"),
                        getCategoriaTarjeta(resultadoConsulta.getInt("codigo_categoria")),
                        resultadoConsulta.getDouble("total_gastado")
                );
                return tarjeta;
            }
        }catch (Exception e){
            return null;
        }
        return null;
    }

    @Override
    public Boolean verificarExistenciaTarjeta(String nit) {
        String consulta = "SELECT * FROM rycc.tarjetapuntos WHERE nit_cliente='" + nit + "'";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            if (resultadoConsulta.next()) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
