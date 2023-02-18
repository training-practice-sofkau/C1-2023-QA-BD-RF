package com.sofka.sofkau.integracion.modelo;

public class VeterinarioTelefono implements ITabla{
    @Override
    public String getTabla() {
        return "telefono_veterinario";
    }
    @Override
    public String getAtributos() {
        return "idEmpleado_telefono,telefono_veterinario";
    }

    @Override
    public String getValores() {
        return (FakerLlenar.getRandom().getRand().nextInt(48)+1)+","+FakerLlenar.getRandom().getFaker().phoneNumber().phoneNumber();
    }
}
