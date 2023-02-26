package com.sofkau.models;

public class VeterinarioReporte {

    private String veterinarioId;
    private String reporteId;

    public VeterinarioReporte() {
    }

    public VeterinarioReporte(String veterinarioId, String reporteId) {
        this.veterinarioId = veterinarioId;
        this.reporteId = reporteId;
    }

    public String getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(String veterinarioId) {
        this.veterinarioId = veterinarioId;
    }

    public String getReporteId() {
        return reporteId;
    }

    public void setReporteId(String reporteId) {
        this.reporteId = reporteId;
    }
}
