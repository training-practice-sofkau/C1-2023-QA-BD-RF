package com.sofkau.database.interfaces;

import com.sofkau.database.clases.CarritoCompraProducto;
import com.sofkau.database.clases.Inventario;

public interface I_Inventario {
    public void insertarInventario(Inventario crearInventario);

    public void disminuirProductoCant (int cantidad, String nombre_producto);

    public Inventario obtenerInventario(String nombre_producto);

}
