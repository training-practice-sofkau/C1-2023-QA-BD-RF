package com.sofkaU.integration.database.models;

public class Cliente {
    Integer id;
    String nombre;
    String cedula;
    String correo;
    String edad;
    String direccion;

    public Cliente(Integer id, String nombre, String cedula, String correo, String edad, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.edad = edad;
        this.direccion = direccion;
    }

    public Cliente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", correo='" + correo + '\'' +
                ", edad='" + edad + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
