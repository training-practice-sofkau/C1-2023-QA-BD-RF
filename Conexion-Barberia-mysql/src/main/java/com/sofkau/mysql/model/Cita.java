package com.sofkau.mysql.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Cita {
    private int id;
    private int cliente;
    private int empleado;
    private Date fechaHora;


    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", empleado=" + empleado +
                ", fechaHora=" + fechaHora +
                '}';
    }

    public Cita() {
    }

    public Cita(int cliente, int empleado, Date fechaHora) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.fechaHora = fechaHora;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
}
