package com.sofkaU.integration.database.models;

import java.util.Date;

public class Cita {
    Integer id;
    Integer idCliente;
    String fecha;
    String hora;

    public Cita(Integer id, Integer idCliente, String fecha, String hora) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Cita() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", fecha=" + fecha +
                ", hora='" + hora + '\'' +
                '}';
    }
}
