package org.sofkau.dbZoo.clases;

public class Alimento_logistico {

    private String id_alimento_;
    private String id_logistico;

    public Alimento_logistico(String id_alimento_, String id_logistico) {
        this.id_alimento_ = id_alimento_;
        this.id_logistico = id_logistico;
    }

    public String getId_alimento_() {
        return id_alimento_;
    }

    public void setId_alimento_(String id_alimento_) {
        this.id_alimento_ = id_alimento_;
    }

    public String getId_logistico() {
        return id_logistico;
    }

    public void setId_logistico(String id_logistico) {
        this.id_logistico = id_logistico;
    }
}
