package com.redalyc.modelo;

import java.util.ArrayList;

public class Volumen {
    private int numero;
    private int noPublicacion;
    private int year;
    private ArrayList<String> articulos;


    public Volumen(int numero, int noPublicacion, int year, ArrayList<String> articulos) {
        this.numero = numero;
        this.noPublicacion = noPublicacion;
        this.year = year;
        this.articulos = articulos;
    }

    public Volumen() {

    }

    public void setArticulos(ArrayList<String> articulos) {
        this.articulos = articulos;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumero() {
        return numero;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<String> getArticulos() {
        return articulos;
    }

    public void setNoPublicacion(int noPublicacion) {
        this.noPublicacion = noPublicacion;
    }

    public int getNoPublicacion() {
        return noPublicacion;
    }
}
