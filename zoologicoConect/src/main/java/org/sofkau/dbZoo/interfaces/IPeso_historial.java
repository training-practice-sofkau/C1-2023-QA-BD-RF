package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Dieta;
import org.sofkau.dbZoo.clases.Peso_historial;

import java.util.List;

public interface IPeso_historial {

    public void insertPeso (Peso_historial crearPeso);
    public List<Peso_historial> mostrarPeso ();
}
