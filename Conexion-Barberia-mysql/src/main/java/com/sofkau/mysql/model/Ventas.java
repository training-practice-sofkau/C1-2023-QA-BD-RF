package com.sofkau.mysql.model;

import java.util.Date;

public class Ventas {
    private int id;
    private int empleadoId;
    private int clienteId;
    private int productoId;

    private Date fecha;

    private Double ligaGanancia;

    public Ventas(int empleadoId, int clienteId, int productoId, Date fecha, Double ligaGanancia) {
        this.empleadoId = empleadoId;
        this.clienteId = clienteId;
        this.productoId = productoId;
        this.fecha = fecha;
        this.ligaGanancia = ligaGanancia;
    }

    public Ventas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }



    public Double getLigaGanancia() {
        return ligaGanancia;
    }

    public void setLigaGanancia(Double ligaGanancia) {
        this.ligaGanancia = ligaGanancia;
    }
}
