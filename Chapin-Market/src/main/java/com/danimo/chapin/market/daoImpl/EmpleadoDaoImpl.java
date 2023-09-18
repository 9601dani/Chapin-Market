package com.danimo.chapin.market.daoImpl;

import com.danimo.chapin.market.conexion.Conexion;
import com.danimo.chapin.market.dao.EmpleadoDao;
import com.danimo.chapin.market.enums.Rol;
import com.danimo.chapin.market.enums.Sucursal;
import com.danimo.chapin.market.model.Empleado;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.danimo.chapin.market.enums.Rol.getIdRol;
import static com.danimo.chapin.market.enums.Sucursal.getIdSucursal;

public class EmpleadoDaoImpl implements EmpleadoDao {
    @Override
    public ArrayList<Empleado> obtenerTodos() {
        String consulta = "SELECT * FROM ryce.empleado;";
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            ArrayList<Empleado> empleados = new ArrayList<>();
            while (resultadoConsulta.next()) {
                Empleado empleado = new Empleado(
                        resultadoConsulta.getInt("codigo_empleado"),
                        resultadoConsulta.getString("nombre"),
                        resultadoConsulta.getString("apellido"),
                        resultadoConsulta.getString("username"),
                        resultadoConsulta.getString("password"),
                        resultadoConsulta.getInt("no_caja"),
                        Sucursal.getSucursal(Integer.parseInt(resultadoConsulta.getString("codigo_sucursal"))),
                        Rol.getRol(Integer.parseInt(resultadoConsulta.getString("codigo_rol")))
                );
                empleados.add(empleado);
            }
            return empleados;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Empleado obtenerPorId(int id) {
        String consulta = "SELECT * FROM ryce.empleado where codigo_empleado=" + id;
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            ResultSet resultadoConsulta = statement.executeQuery();
            if (resultadoConsulta.next()) {
                Empleado empleado = new Empleado(
                        resultadoConsulta.getInt("codigo_empleado"),
                        resultadoConsulta.getString("nombre"),
                        resultadoConsulta.getString("apellido"),
                        resultadoConsulta.getString("username"),
                        resultadoConsulta.getString("password"),
                        resultadoConsulta.getInt("no_caja"),
                        Sucursal.getSucursal(Integer.parseInt(resultadoConsulta.getString("codigo_sucursal"))),
                        Rol.getRol(Integer.parseInt(resultadoConsulta.getString("codigo_rol")))
                );
                return empleado;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertar(Empleado empleado) {
        String consulta = "INSERT INTO ryce.empleado (nombre, apellido, username, password, no_caja, codigo_sucursal, codigo_rol) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getApellido());
            statement.setString(3, empleado.getUsername());
            statement.setString(4, empleado.getPassword());
            statement.setInt(5, empleado.getNo_caja());
            statement.setInt(6, getIdSucursal(empleado.getSucursal_id()));
            statement.setInt(7, getIdRol(empleado.getRol_id()));
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Empleado agregado correctamente");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void actualizar(Empleado empleado) {
        String consulta = "UPDATE ryce.empleado SET nombre=?, apellido=?, username=?, password=?, no_caja=?, codigo_sucursal=?, codigo_rol=? WHERE codigo_empleado=?;";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getApellido());
            statement.setString(3, empleado.getUsername());
            statement.setString(4, empleado.getPassword());
            statement.setInt(5, empleado.getNo_caja());
            statement.setInt(6, getIdSucursal(empleado.getSucursal_id()));
            statement.setInt(7, getIdRol(empleado.getRol_id()));
            statement.setInt(8, empleado.getId());
            statement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String consulta = "DELETE FROM ryce.empleado WHERE codigo_empleado=?;";
        try{
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
