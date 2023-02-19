package com.sofkau.integration.models;


public class telefono_logistico {
    String logisticoId;
    String numero;

    public telefono_logistico() {
    }

    public telefono_logistico(String logisticoId, String numero) {
        this.logisticoId = logisticoId;
        this.numero = numero;
    }

    public String getLogisticoId() {
        return logisticoId;
    }

    public void setLogisticoId(String logisticoId) {
        this.logisticoId = logisticoId;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "telefono_logistico{" +
                "logisticoId='" + logisticoId + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
