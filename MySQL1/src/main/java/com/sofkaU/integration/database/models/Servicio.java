package com.sofkaU.integration.database.models;

public class Servicio {
    Integer id;
    Integer idCita;
    double precio;
    String descripcion;
    String fecha;
    double duracion;

    public Servicio(Integer id, Integer idCita, double precio, String descripcion, String fecha, double duracion) {
        this.id = id;
        this.idCita = idCita;
        this.precio = precio;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public Servicio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "servicio{" +
                "id=" + id +
                ", idCita=" + idCita +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}
