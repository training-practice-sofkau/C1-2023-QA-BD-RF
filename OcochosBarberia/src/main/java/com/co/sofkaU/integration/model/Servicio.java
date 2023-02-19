package com.co.sofkaU.integration.model;

import lombok.Data;

@Data
public class Servicio {
    private int idServicio;
    private int duracion;
    private int idClienteS;
    private int idEmpleadoS;
    private String fechaServicio;
    private String descripcion;
}
