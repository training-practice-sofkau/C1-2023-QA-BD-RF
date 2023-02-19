package org.sofkau.dbZoo.clases;

public class Entrenador_animal {

    private String id_animal_;
    private String id_entrenador_;

    public Entrenador_animal(String id_animal_, String id_entrenador_) {
        this.id_animal_ = id_animal_;
        this.id_entrenador_ = id_entrenador_;
    }

    public String getId_animal_() {
        return id_animal_;
    }

    public void setId_animal_(String id_animal_) {
        this.id_animal_ = id_animal_;
    }

    public String getId_entrenador_() {
        return id_entrenador_;
    }

    public void setId_entrenador_(String id_entrenador_) {
        this.id_entrenador_ = id_entrenador_;
    }
}
