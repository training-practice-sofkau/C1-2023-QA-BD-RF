package org.sofkau.dbZoo.clases;

public class Proveedor_factura {
    private String id_proveed;
    private String id_factura;

    public Proveedor_factura(String id_proveed, String id_factura) {
        this.id_proveed = id_proveed;
        this.id_factura = id_factura;
    }

    public String getId_proveed() {
        return id_proveed;
    }

    public void setId_proveed(String id_proveed) {
        this.id_proveed = id_proveed;
    }

    public String getId_factura() {
        return id_factura;
    }

    public void setId_factura(String id_factura) {
        this.id_factura = id_factura;
    }
}
