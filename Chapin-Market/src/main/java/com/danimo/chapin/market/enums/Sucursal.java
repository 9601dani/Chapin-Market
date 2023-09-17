
package com.danimo.chapin.market.enums;
public enum Sucursal {
    CENTRAL,
    NORTE,
    SUR;

    public static Sucursal getSucursal(int id){
        switch (id){
            case 1:
                return Sucursal.CENTRAL;
            case 2:
                return Sucursal.NORTE;
            case 3:
                return Sucursal.SUR;
            default:
                return null;
        }
    }

}

