package com.danimo.chapin.market.enums;

public enum Rol {
    CAJERO,
    BODEGUERO,
    INVENTARISTA,
    ADMINISTRADOR;

    public static Rol getRol(int id){
        switch (id){
            case 1:
                return Rol.CAJERO;
            case 2:
                return  Rol.BODEGUERO;
            case 3:
                return  Rol.INVENTARISTA;
            case 4:
                return  Rol.ADMINISTRADOR;
            default:
                return null;
        }
    }

    public static int getIdRol(Rol rol){
        switch (rol){
            case CAJERO:
                return 1;
            case BODEGUERO:
                return 2;
            case INVENTARISTA:
                return 3;
            case ADMINISTRADOR:
                return 4;
            default:
                return 0;
        }
    }
}
