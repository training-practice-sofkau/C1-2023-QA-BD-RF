package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Dieta;
import org.sofkau.dbZoo.clases.Entrenador_animal;

import java.util.List;

public interface IEntrenador_animal {

    public void inserEntrenador_animal (Entrenador_animal crearEntrenador_animal);
    public List<Entrenador_animal> mostrarEntrenador_animal();
}
