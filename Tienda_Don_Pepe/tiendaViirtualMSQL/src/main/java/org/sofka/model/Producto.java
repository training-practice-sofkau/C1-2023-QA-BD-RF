package org.sofka.model;

public class Producto {

    private String id;
    private String nombre;
    private String origen;
    private String marca;
    private String peso;
    private int stock;
    private String precio;
    private int idProveeedor;
    private String idCategoria;

    public Producto() {
    }


    public Producto(String id, String nombre, String origen, String marca,
                    String peso, int stock, String precio, int idProveeedor,
                    String idCategoria) {
        this.id = id;
        this.nombre = nombre;
        this.origen = origen;
        this.marca = marca;
        this.peso = peso;
        this.stock = stock;
        this.precio = precio;
        this.idProveeedor = idProveeedor;
        this.idCategoria = idCategoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getIdProveeedor() {
        return idProveeedor;
    }

    public void setIdProveeedor(int idProveeedor) {
        this.idProveeedor = idProveeedor;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }
}
