/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.danimo.chapin.market.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author danimo
 */
public class Conexion {
    public static Connection conexion;
    private static final String URL="jdbc:postgresql://localhost:5432/chapinmarket";
    private static final String USUARIO="chapinmarket";
    private static final String CLAVE="chapinmarket";
    public static Connection obtenerConexion(){
        try{
            if(conexion==null){
                Class.forName("org.postgresql.Driver");
                conexion= DriverManager.getConnection(URL,USUARIO,CLAVE);
                System.out.println("Conexion exitosa");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.printf("Error al obtener la conexion");
        }
        return conexion;
    }

}
