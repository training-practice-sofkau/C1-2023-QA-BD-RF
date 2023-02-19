package com.sofkau.database.interfaces;

import com.sofkau.database.clases.Cliente;
import com.sofkau.database.clases.Producto;

import java.util.List;

public interface I_Producto {

    public void insertarProducto (Producto crearProducto);
    public List<Producto> mostrarProducto ();

    public Producto obteberProducto(String nom_producto);


}
