package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Dieta;
import org.sofkau.dbZoo.clases.Dieta_veterinario;

import java.util.List;

public interface IDieta_veterinario {

    public void insertDietaVeterinario (Dieta_veterinario crearDietaVeterinario);
    public List<Dieta_veterinario> mostrarDietaVeterinario ();
}
