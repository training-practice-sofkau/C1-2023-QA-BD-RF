package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Alimento;
import org.sofkau.dbZoo.clases.Clasificacion_animal;

import java.util.List;

public interface IClasificacion_animal {

    public void insertClasificacion_animal (Clasificacion_animal crearClasificacion_animal);
    public List<Clasificacion_animal> mostrarClasificacionAnimal ( );
}
