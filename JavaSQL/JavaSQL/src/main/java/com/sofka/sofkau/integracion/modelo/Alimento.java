package com.sofka.sofkau.integracion.modelo;

import java.util.List;

public class Alimento implements ITabla{
    private List<String> tipo= List.of("humeda","seca","mixta");
    @Override
    public String getTabla() {
        return "alimento";
    }
    @Override
    public boolean esForanea() {
        return true;
    }

    @Override
    public String getAtributos() {
        return "dosis,tipo,nombre,idProveedor";
    }

    @Override
    public String getValores() {
        return FakerLlenar.getRandom().getRand().nextInt(500)+1
                +" gr"+","+this.tipo.get(FakerLlenar.getRandom().getRand().nextInt(2)+1)
                +","+"comida"+","+FakerLlenar.getRandom().getRand().nextInt(49)+1;
    }
}
