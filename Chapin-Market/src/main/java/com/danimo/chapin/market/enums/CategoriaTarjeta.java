package com.danimo.chapin.market.enums;

public enum CategoriaTarjeta {
    COMUN,
    ORO,
    PLATINO,
    DIAMANTE;

    public static CategoriaTarjeta getCategoriaTarjeta(int id){
        switch (id){
            case 1:
                return CategoriaTarjeta.COMUN;
            case 2:
                return  CategoriaTarjeta.ORO;
            case 3:
                return  CategoriaTarjeta.PLATINO;
            case 4:
                return  CategoriaTarjeta.DIAMANTE;
            default:
                return null;
        }
    }

    public static int getIdCategoriaTarjeta(CategoriaTarjeta categoriaTarjeta){
        switch (categoriaTarjeta){
            case COMUN:
                return 1;
            case ORO:
                return 2;
            case PLATINO:
                return 3;
            case DIAMANTE:
                return 4;
            default:
                return 0;
        }
    }

    public static String getNombreCategoriaTarjeta(CategoriaTarjeta categoriaTarjeta){
        switch (categoriaTarjeta){
            case COMUN:
                return "Común";
            case ORO:
                return "Oro";
            case PLATINO:
                return "Platino";
            case DIAMANTE:
                return "Diamante";
            default:
                return null;
        }
    }
}
