package com.sofka.sofkau.integracion.modelo;
import java.util.List;
public class Animal implements ITabla{
    private List<String> clasificacion= List.of("mamiferos","aves","anfibios","peces","reptíles");
    @Override
    public String getTabla() {
        return "animal";
    }

    @Override
    public boolean esForanea() {
        return false;
    }

    @Override
    public String getAtributos() {
        return "nombre,peso,clasificacion";
    }

    @Override
    public String getValores() {
        return FakerLlenar.getRandom().getFaker().animal().name()
                +","+FakerLlenar.getRandom().getRand().nextInt(1000-50)+50
                +","+this.clasificacion.get(FakerLlenar.getRandom().getRand().nextInt(4)+1);
    }
}
