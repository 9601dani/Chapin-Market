/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.danimo.chapin.market;

import com.danimo.chapin.market.conexion.Conexion;
import com.danimo.chapin.market.view.Main;
import java.beans.PropertyVetoException;

/**
 *
 * @author danimo
 */
public class ChapinMarket {

    public static void main(String[] args) throws PropertyVetoException {
        Main login= new Main();
        login.show();
    }
}
