package com.sofkau.database.interfaces;

import com.sofkau.database.clases.Categoria;

import java.util.List;

public interface I_Categoria {
    public void insertarCategoria (Categoria crearCategoria);
    public List<Categoria> mostrarCategoria();
}
