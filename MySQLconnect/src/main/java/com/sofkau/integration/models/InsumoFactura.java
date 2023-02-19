package com.sofkau.integration.models;

public class InsumoFactura {
    private int idFactura;
    private int idInsumo;

    public InsumoFactura(int idFactura, int idInsumo) {
        this.idFactura = idFactura;
        this.idInsumo = idInsumo;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }
}
