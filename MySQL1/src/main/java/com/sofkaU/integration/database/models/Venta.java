package com.sofkaU.integration.database.models;

public class Venta {
    Integer id;
    double valorTotal;
    double liga;
    String fecha;
    Integer idProducto;
    Integer idCotizacion;
    Integer cantidad;

    public Venta(Integer id, double valorTotal, double liga, String fecha, Integer idProducto, Integer idCotizacion, Integer cantidad) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.liga = liga;
        this.fecha = fecha;
        this.idProducto = idProducto;
        this.idCotizacion = idCotizacion;
        this.cantidad = cantidad;
    }

    public Venta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getLiga() {
        return liga;
    }

    public void setLiga(double liga) {
        this.liga = liga;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", liga=" + liga +
                ", fecha='" + fecha + '\'' +
                ", idProducto=" + idProducto +
                ", idCotizacion=" + idCotizacion +
                ", cantidad=" + cantidad +
                '}';
    }
}
