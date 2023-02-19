package com.sofkau.integration.models;

public class Cliente {
    private int idCliente;
    private String nombreCliente;
    private String cedulaCliente;
    private String profesion;
    private String correo;
    private int edad;
    private String direccion;

    public Cliente(int idCliente, String nombreCliente, String cedulaCliente, String profesion, String correo, int edad, String direccion) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.cedulaCliente = cedulaCliente;
        this.profesion = profesion;
        this.correo = correo;
        this.edad = edad;
        this.direccion = direccion;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
