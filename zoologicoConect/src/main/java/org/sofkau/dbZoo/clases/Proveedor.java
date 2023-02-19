package org.sofkau.dbZoo.clases;

public class Proveedor {

    private String id_proveedor;
    private String nombre;
    private String direccion;
    private String correo;

   public Proveedor(String id_proveedor, String nombre, String direccion, String correo) {
     this.id_proveedor = id_proveedor;
     this.nombre = nombre;
     this.direccion = direccion;
     this.correo = correo;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
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
}
