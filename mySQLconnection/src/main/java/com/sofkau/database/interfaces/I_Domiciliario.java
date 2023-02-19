package com.sofkau.database.interfaces;

import com.sofkau.database.clases.Categoria;
import com.sofkau.database.clases.Domiciliario;

import java.util.List;

public interface I_Domiciliario {

    public void insertarDomiciliario (Domiciliario crearDomiciliario);
    public List<Domiciliario> mostrarDomiciliario();

    public Domiciliario obtenerDomiciliario(String cedula_domiciliario);
}
