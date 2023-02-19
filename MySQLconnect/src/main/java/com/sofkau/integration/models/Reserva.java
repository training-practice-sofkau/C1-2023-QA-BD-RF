package com.sofkau.integration.models;

import java.util.Date;

public class Reserva {
    private int id_reserva;
    private int id_cliente;
    private String estado;
    private Date fecha_reserva;
    private String descripcion;

    public Reserva() {
    }

    public Reserva(int id_reserva, int id_cliente, String estado, Date fecha_reserva, String descripcion) {
        this.id_reserva = id_reserva;
        this.id_cliente = id_cliente;
        this.estado = estado;
        this.fecha_reserva = fecha_reserva;
        this.descripcion = descripcion;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
