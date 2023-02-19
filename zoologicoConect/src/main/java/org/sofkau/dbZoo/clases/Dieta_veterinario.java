package org.sofkau.dbZoo.clases;

public class Dieta_veterinario {

    private String id_dieta_;
    private String id_veterinario;

    public Dieta_veterinario(String id_dieta_, String id_veterinario) {
        this.id_dieta_ = id_dieta_;
        this.id_veterinario = id_veterinario;
    }

    public String getId_dieta_() {
        return id_dieta_;
    }

    public void setId_dieta_(String id_dieta_) {
        this.id_dieta_ = id_dieta_;
    }

    public String getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(String id_veterinario) {
        this.id_veterinario = id_veterinario;
    }
}
