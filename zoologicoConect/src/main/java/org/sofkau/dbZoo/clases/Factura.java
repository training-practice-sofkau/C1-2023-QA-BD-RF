package org.sofkau.dbZoo.clases;

public class Factura {

    private String id_factura;
    private String fecha;
    private String total;

    public Factura(String id_factura, String fecha, String total) {
        this.id_factura = id_factura;
        this.fecha = fecha;
        this.total = total;
    }

    public String getId_factura() {
        return id_factura;
    }

    public void setId_factura(String id_factura) {
        this.id_factura = id_factura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
