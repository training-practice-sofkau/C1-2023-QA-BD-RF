package com.co.sofkaU.integration.model;

import lombok.Data;

@Data
public class Venta {
    private int idVenta;
    private int idClienteV;
    private int idEmpleadoV;
    private double liga;
    private String fechaVenta;
}
