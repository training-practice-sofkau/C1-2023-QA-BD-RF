package com.sofka.sofkau.integracion.modelo;
public class Dieta implements ITabla{
    @Override
    public String getTabla() {
        return "dieta";
    }
    @Override
    public String getAtributos() {
        return "idEmpleado_veterinario";
    }
    @Override
    public String getValores() {
        return ""+FakerLlenar.getRandom().getRand().nextInt(48)+1;
    }
}
