package com.sofkaU.integration.database.models;

public class ServicioInsumo {
    Integer idServicio;
    Integer REFinsumo;

    public ServicioInsumo(Integer idServicio, Integer REFinsumo) {
        this.idServicio = idServicio;
        this.REFinsumo = REFinsumo;
    }

    public ServicioInsumo() {
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Integer getREFinsumo() {
        return REFinsumo;
    }

    public void setREFinsumo(Integer REFinsumo) {
        this.REFinsumo = REFinsumo;
    }

    @Override
    public String toString() {
        return "ServicioInsumo{" +
                "idServicio=" + idServicio +
                ", REFinsumo=" + REFinsumo +
                '}';
    }
}
