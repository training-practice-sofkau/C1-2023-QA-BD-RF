package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Dieta;
import org.sofkau.dbZoo.clases.Veterinario;

import java.util.List;

public interface IVeterinario {

    public void insertVeterinario (Veterinario crearVeterinario);
    public List<Veterinario> mostrarVeterinario ();
}
