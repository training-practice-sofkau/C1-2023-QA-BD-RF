package org.sofkau.dbZoo.interfaces;

import org.sofkau.dbZoo.clases.Dieta;
import org.sofkau.dbZoo.clases.Emp_logistico;

import java.util.List;

public interface IEmp_logistico {

    public void insertEmp_logistico (Emp_logistico crearEmp_logistico);
    public List<Emp_logistico> mostrarEmp_logistico ();
}
