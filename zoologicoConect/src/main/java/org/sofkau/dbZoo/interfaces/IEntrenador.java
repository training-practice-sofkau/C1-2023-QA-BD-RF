package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Dieta;
import org.sofkau.dbZoo.clases.Entrenador;

import java.util.List;

public interface IEntrenador {

    public void insertEntrenador (Entrenador crearEntrenador);
    public List<Entrenador> mostrarEntrenador ();
}
