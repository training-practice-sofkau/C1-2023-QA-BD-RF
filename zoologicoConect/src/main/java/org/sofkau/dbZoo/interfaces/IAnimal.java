package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Alimento;
import org.sofkau.dbZoo.clases.Animal;

import java.util.List;

public interface IAnimal {

    public void insertAnimal (Animal crearAnimal);
    public List<Animal> mostrarAnimal ( );
}
