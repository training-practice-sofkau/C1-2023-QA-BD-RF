package com.sofkau.integration.models;

public class VeterinarioInforme {
    private String id_veterinario_informe;
    private String id_informe_veterinario;

    public VeterinarioInforme(String id_veterinario_informe, String id_informe_veterinario) {
        this.id_veterinario_informe = id_veterinario_informe;
        this.id_informe_veterinario = id_informe_veterinario;
    }

    public VeterinarioInforme() {
    }

    public String getId_veterinario_informe() {
        return id_veterinario_informe;
    }

    public void setId_veterinario_informe(String id_veterinario_informe) {
        this.id_veterinario_informe = id_veterinario_informe;
    }

    public String getId_informe_veterinario() {
        return id_informe_veterinario;
    }

    public void setId_informe_veterinario(String id_informe_veterinario) {
        this.id_informe_veterinario = id_informe_veterinario;
    }

    @Override
    public String toString() {
        return "VeterinarioInforme{" +
                "id_veterinario_informe='" + id_veterinario_informe + '\'' +
                ", id_informe_veterinario='" + id_informe_veterinario + '\'' +
                '}';
    }
}
