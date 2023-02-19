package org.sofka.model;

public class Cliente {
private String id;
private String cedula;
private String nombre;
private String email;
private String password;

private String zonaPostal;

    public Cliente() {
    }

    public Cliente(String id, String cedula, String nombre, String email, String password, String zonaPostal) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.zonaPostal = zonaPostal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getZonaPostal() {
        return zonaPostal;
    }

    public void setZonaPostal(String zonaPostal) {
        this.zonaPostal = zonaPostal;
    }
}

