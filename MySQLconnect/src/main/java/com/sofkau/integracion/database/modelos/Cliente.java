package com.sofkau.integracion.database.modelos;

public class Cliente {
    private String cedulaCliente;
    private String nombreCliente;
    private String direccion;
    private String email;
    private String password;
    private String idZona;

    public Cliente(String cedulaCliente, String nombreCliente, String direccion,
                   String email, String password, String idZona) {
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.email = email;
        this.password = password;
        this.idZona = idZona;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdZona() {
        return idZona;
    }

    public void setIdZona(String idZona) {
        this.idZona = idZona;
    }
}
