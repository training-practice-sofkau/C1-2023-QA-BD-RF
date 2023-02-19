package com.sofkau.database.clases;

public class Cliente {
    private String ced_cliente;
    private String nombre ;
    private String direccion;
    private String correo;
    private String contrasena;
    private String codigo_postal;

    public Cliente(String ced_cliente, String nombre, String direccion, String correo, String contrasena, String codigo_postal) {
        this.ced_cliente = ced_cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.contrasena = contrasena;
        this.codigo_postal = codigo_postal;
    }

    public String getCed_cliente() {
        return ced_cliente;
    }

    public void setCed_cliente(String ced_cliente) {
        this.ced_cliente = ced_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }
}
