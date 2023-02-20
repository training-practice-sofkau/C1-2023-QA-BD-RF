package org.sofka.model;

public class TelefonoProveedor {
    private int idproveedor;
    private String telefono;

    public TelefonoProveedor() {
    }

    public TelefonoProveedor(int idproveedor, String telefono) {
        this.idproveedor = idproveedor;
        this.telefono = telefono;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
