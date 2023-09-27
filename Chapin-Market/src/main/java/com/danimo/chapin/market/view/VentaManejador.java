package com.danimo.chapin.market.view;

public class VentaManejador {

    public boolean verificarPuntos(int puntos, int puntos_solicitados){
        if (puntos >= puntos_solicitados){
            return true;
        }
        return false;
    }


}
