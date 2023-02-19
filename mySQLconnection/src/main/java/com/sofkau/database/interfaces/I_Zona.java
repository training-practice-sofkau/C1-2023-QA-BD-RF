package com.sofkau.database.interfaces;

import com.sofkau.database.clases.Categoria;
import com.sofkau.database.clases.Zona;

import java.util.List;

public interface I_Zona {
    public void insertarZona (Zona crearZona);
    public List<Zona> mostrarZona ();
}
