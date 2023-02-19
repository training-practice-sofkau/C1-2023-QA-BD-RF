package com.sofkau.integration.models;

import java.sql.Time;
import java.util.Date;



public class Cita {
    private int idCita;
    private int idReserva;
    private Date fecha;
    private Time hora;
    private String descripcion;

    public Cita(int idCita, int idReserva, Date fecha, Time hora, String descripcion) {
        this.idCita = idCita;
        this.idReserva = idReserva;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
    }

    public Cita() {
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdReserva(int i) {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}