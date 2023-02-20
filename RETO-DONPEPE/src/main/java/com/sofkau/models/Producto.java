package com.sofkau.models;

public class Producto {
    private String nombre;
    private String marca;
    private String origen;
    private String volumen;
    private String foto;
    private String idProvedor;
    private int idCategoria;
    private double precio;
    private String peso;

    public Producto() {

    }
    public Producto(String nombre, String marca, String origen, String volumen,
                    String foto, String idProvedor, int idCategoria, double precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.origen = origen;
        this.volumen = volumen;
        this.foto = foto;
        this.idProvedor = idProvedor;
        this.idCategoria = idCategoria;
        this.precio = precio;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getIdProvedor() {
        return idProvedor;
    }

    public void setIdProvedor(String idProvedor) {
        this.idProvedor = idProvedor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", origen='" + origen + '\'' +
                ", volumen='" + volumen + '\'' +
                ", foto='" + foto + '\'' +
                ", idProvedor='" + idProvedor + '\'' +
                ", idCategoria=" + idCategoria +
                ", precio=" + precio +
                ", peso='" + peso + '\'' +
                '}';
    }
}
