package com.redalyc.modelo;

import java.util.ArrayList;

public class RevistaC {
    private int clave;
    ArrayList<Volumen> volumnes;

    RevistaC(int clave, ArrayList<Volumen> volumnes){
        this.clave=clave;
        this.volumnes=volumnes;
    }

    public RevistaC(){

    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void setVolumnes(ArrayList<Volumen> volumnes) {
        this.volumnes = volumnes;
    }

    public int getClave() {
        return clave;
    }

    public ArrayList<Volumen> getVolumnes() {
        return volumnes;
    }
}
