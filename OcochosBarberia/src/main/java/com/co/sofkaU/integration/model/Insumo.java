package com.co.sofkaU.integration.model;

import lombok.Data;

@Data
public class Insumo {
    private int REFInsumo;
    private int cantidadInsumo;
    private String nombreInsumo;

    public Insumo(int cantidadInsumo, String nombreInsumo) {
        this.cantidadInsumo = cantidadInsumo;
        this.nombreInsumo = nombreInsumo;
    }
}
