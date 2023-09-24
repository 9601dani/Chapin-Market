
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

    public static int getIdSucursal(Sucursal sucursal){
        switch (sucursal){
            case CENTRAL:
                return 1;
            case NORTE:
                return 2;
            case SUR:
                return 3;
            default:
                return 0;
        }
    }
    
    public static String getStringSucursal(Sucursal sucursal){
        switch (sucursal){
            case CENTRAL:
                return "CENTRAL";
            case NORTE:
                return "NORTE";
            case SUR:
                return "SUR";
            default:
                return "ERROR";
        }
    }

}

