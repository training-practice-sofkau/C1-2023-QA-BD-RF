package com.sofkau.integration.models;

public class Factura {

    private String id_factura;
    private String total;
    private String nit_proveedor_factura;

    public Factura(String id_factura, String total, String nit_proveedor_factura) {
        this.id_factura = id_factura;
        this.total = total;
        this.nit_proveedor_factura = nit_proveedor_factura;
    }

    public Factura() {
    }

    public String getId_factura() {
        return id_factura;
    }

    public void setId_factura(String id_factura) {
        this.id_factura = id_factura;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getNit_proveedor_factura() {
        return nit_proveedor_factura;
    }

    public void setNit_proveedor_factura(String nit_proveedor_factura) {
        this.nit_proveedor_factura = nit_proveedor_factura;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id_factura='" + id_factura + '\'' +
                ", total='" + total + '\'' +
                ", nit_proveedor_factura='" + nit_proveedor_factura + '\'' +
                '}';
    }
}
