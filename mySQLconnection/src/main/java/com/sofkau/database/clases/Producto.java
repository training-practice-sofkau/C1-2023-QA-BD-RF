package com.sofkau.database.clases;

public class Producto {
    private String nom_producto;
    private String marca;
    private String dimension;
    private String foto;
    private double precio;
    private  int id_categoria;

    public Producto(String nom_producto, String marca, String dimension, String foto, double precio, int id_categoria) {
        this.nom_producto = nom_producto;
        this.marca = marca;
        this.dimension = dimension;
        this.foto = foto;
        this.precio = precio;
        this.id_categoria = id_categoria;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
}
