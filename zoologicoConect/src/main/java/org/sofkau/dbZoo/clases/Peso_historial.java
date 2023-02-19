package org.sofkau.dbZoo.clases;

public class Peso_historial {

    private String id_animales_;
    private String peso;

    public Peso_historial(String id_animales_, String peso) {
        this.id_animales_ = id_animales_;
        this.peso = peso;
    }

    public String getId_animales_() {
        return id_animales_;
    }

    public void setId_animales_(String id_animales_) {
        this.id_animales_ = id_animales_;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
}
