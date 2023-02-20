package org.sofka.model;

public class ZonaPostal {
    private String  id;
    private String zonaPostal;
    private String codigoPostal;

    public ZonaPostal() {
    }

    public ZonaPostal(String id, String zonaPostal, String codigoPostal) {
        this.id = id;
        this.zonaPostal = zonaPostal;
        this.codigoPostal = codigoPostal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZonaPostal() {
        return zonaPostal;
    }

    public void setZonaPostal(String zonaPostal) {
        this.zonaPostal = zonaPostal;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
