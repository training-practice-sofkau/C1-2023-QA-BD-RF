package com.sofkau.mysql.model;

import java.util.Date;

public class Servicios {
    private Integer id ;
    private Integer empleado_id;
    private Integer cliente_id;
    private String productos_consumidos;
    private Integer duracion_procedimiento;

    private Date fecha;


    public Servicios(Integer empleado_id, Integer cliente_id, String productos_consumidos, Integer duracion_procedimiento, Date fecha) {
        this.empleado_id = empleado_id;
        this.cliente_id = cliente_id;
        this.productos_consumidos = productos_consumidos;
        this.duracion_procedimiento = duracion_procedimiento;
        this.fecha = fecha;
    }

    public Servicios() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(Integer empleado_id) {
        this.empleado_id = empleado_id;
    }

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getProductos_consumidos() {
        return productos_consumidos;
    }

    public void setProductos_consumidos(String productos_consumidos) {
        this.productos_consumidos = productos_consumidos;
    }

    public Integer getDuracion_procedimiento() {
        return duracion_procedimiento;
    }

    public void setDuracion_procedimiento(Integer duracion_procedimiento) {
        this.duracion_procedimiento = duracion_procedimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
