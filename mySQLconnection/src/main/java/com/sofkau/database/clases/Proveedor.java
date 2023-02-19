package com.sofkau.database.clases;

public class Proveedor {

    private String razon_social;
    private String telefono;
    private String correo;

    public Proveedor(String razon_social, String telefono, String correo) {
        this.razon_social = razon_social;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
