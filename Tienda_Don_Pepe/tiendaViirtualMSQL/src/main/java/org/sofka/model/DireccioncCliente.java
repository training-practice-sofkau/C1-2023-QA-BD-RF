package org.sofka.model;

public class DireccioncCliente {
    private int id;
    private String calle;
    private String numero;
    private String barrio;
    private String idCliente;

    public DireccioncCliente() {
    }

    public DireccioncCliente(int id, String calle, String numero, String barrio, String idCliente) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.barrio = barrio;
        this.idCliente = idCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
}
