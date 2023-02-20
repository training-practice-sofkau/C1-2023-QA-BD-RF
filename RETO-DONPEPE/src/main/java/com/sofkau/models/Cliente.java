package com.sofkau.models;

public class Cliente {
    private int id;
    private String nombre;
    private String cedula;
    private String direccion;
    private String telefono;
    private String correo;
    private String contrasena;
    private int codigo_postal;

    public Cliente() {
    }

    public Cliente( int id, String nombre, String cedula, String direccion,
                   String telefono, String correo, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
        this.codigo_postal = 1;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", codigo_postal=" + codigo_postal +
                '}';
    }
}
