package com.dani.recycledview;

public class Coche {

    String marca, modelo;
    int cv;
    int puertas;
    int precio;
    int imagen;

    public Coche(int imagen, String marca, String modelo, int cv, int puertas, int precio) {
        this.imagen = imagen;
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.puertas = puertas;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

}
