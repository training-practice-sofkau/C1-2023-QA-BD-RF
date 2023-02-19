package com.co.sofkaU.integration.model;

import lombok.Data;

@Data
public class Cita {
    private int idCita;
    private int idClienteC;
    private int idEmpleadoC;
    private String fechaCita;
}
