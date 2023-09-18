package com.danimo.chapin.market.handlers;

import com.danimo.chapin.market.model.Empleado;
import com.danimo.chapin.market.conexion.Conexion;
import com.danimo.chapin.market.enums.Rol;
import com.danimo.chapin.market.enums.Sucursal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MLogin {
    /**
     * @param parametro1 usuario a consultar
     * @param parametro2 clave a consultar
     * @return true si el usuario y clave son correctos
     * @throws java.lang.Exception
     *
     * Este método valida si el usuario y clave son correctos luego de consultarlo a la bd (postgres)
     */

    public int validarUsuario(String parametro1, String parametro2) throws Exception {
        System.out.println("VOY A REALIZAR LA CONSULTA");
        boolean resultado = false;
        String consulta="";
        consulta="SELECT * FROM ryce.empleado where username='"+parametro1+"' and password='"+parametro2+"'";

        PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(consulta);
        ResultSet resultadoConsulta = statement.executeQuery();
        if (resultadoConsulta.next()) {
            int nombre= Integer.parseInt(resultadoConsulta.getString("codigo_empleado"));
            return nombre;
        }
        return -1;
    }

    /*Metodo para obtener un objeto empleado con su id*/

    public Empleado obtenerEmpleado(int id) throws Exception {
        String consulta="";
        consulta="SELECT * FROM ryce.empleado where codigo_empleado="+id;

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
        return null;
    }



    
}
