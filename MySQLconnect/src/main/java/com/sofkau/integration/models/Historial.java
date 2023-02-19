package com.sofkau.integration.models;

import java.util.Date;

public class Historial {
    private int idEmpleado;
    private int idServicio;
    private String productosConsumidos;
    private int duracionProcedimiento;
    private Date fechaServicio;

    public Historial(int idEmpleado, int idServicio, String productosConsumidos, int duracionProcedimiento, Date fechaServicio) {
        this.idEmpleado = idEmpleado;
        this.idServicio = idServicio;
        this.productosConsumidos = productosConsumidos;
        this.duracionProcedimiento = duracionProcedimiento;
        this.fechaServicio = fechaServicio;
    }

    public Historial() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getProductosConsumidos() {
        return productosConsumidos;
    }

    public void setProductosConsumidos(String productosConsumidos) {
        this.productosConsumidos = productosConsumidos;
    }

    public int getDuracionProcedimiento() {
        return duracionProcedimiento;
    }

    public void setDuracionProcedimiento(int duracionProcedimiento) {
        this.duracionProcedimiento = duracionProcedimiento;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }
}
