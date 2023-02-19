package com.sofkau.integration.models;

public class InsumoServicio {
    private int idInsumo;
    private int idServicio;

    public InsumoServicio(int idInsumo, int idServicio) {
        this.idInsumo = idInsumo;
        this.idServicio = idServicio;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
}
