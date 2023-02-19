package com.sofkaU.integration.database.models;

public class ClienteProfesion {
    Integer idCliente;
    String profesion;

    public ClienteProfesion(Integer idCliente, String profesion) {
        this.idCliente = idCliente;
        this.profesion = profesion;
    }

    public ClienteProfesion() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return "ClienteProfesion{" +
                "idCliente=" + idCliente +
                ", profesion='" + profesion + '\'' +
                '}';
    }
}
