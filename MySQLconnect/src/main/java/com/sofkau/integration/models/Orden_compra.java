package com.sofkau.integration.models;

public class Orden_compra {
    String idOrden_compra;
    String fecha_compra;
    String idlogista;
    String idProveedores;

    public Orden_compra(String idOrden_compra, String fecha_compra, String idlogista, String idProveedores) {
        this.idOrden_compra = idOrden_compra;
        this.fecha_compra = fecha_compra;
        this.idlogista = idlogista;
        this.idProveedores = idProveedores;
    }

    public Orden_compra() {
    }

    public String getIdOrden_compra() {
        return idOrden_compra;
    }

    public void setIdOrden_compra(String idOrden_compra) {
        this.idOrden_compra = idOrden_compra;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getIdlogista() {
        return idlogista;
    }

    public void setIdlogista(String idlogista) {
        this.idlogista = idlogista;
    }

    public String getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(String idProveedores) {
        this.idProveedores = idProveedores;
    }
    @Override
    public String toString() {
        return "Orden_compra{" +
                "idOrden_compra='" + idOrden_compra + '\'' +
                ", fecha_compra='" + fecha_compra + '\'' +
                ", idlogista='" + idlogista + '\'' +
                ", idProveedores='" + idProveedores + '\'' +
                '}';
    }
}
