package org.sofka.repository;

import org.sofka.integration.database.mysql.MySqlOperation;
import org.sofka.model.Categoria;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepository implements Table {

    private Categoria categoria;
    private MySqlOperation mySqlOperation;

    public CategoriaRepository() throws SQLException {

    }

    public void deleteAllRow() {
        String sql=String.format("DELETE * FROM CATEGORIA");
        this.mySqlOperation.myOpenConnection();
        this.mySqlOperation.myExecuteInsertUpdate(sql);
        this.mySqlOperation.myCloseConnection();

    }


    @Override
    public void  generateData() throws SQLException {
        mySqlOperation = new MySqlOperation();
        mySqlOperation.configureDatabaseconetion();

        List <Categoria>   categorias= new ArrayList<Categoria>();
        categorias.add(new Categoria("110", "Electronicos", "seco", "cuidado personal"));
        categorias.add(new Categoria( "120", "Medicamentos", "frio", "gaseosa"));
        categorias.add(new Categoria("130", "Inflamables", "frio", "Queso "));
        categorias.add(new Categoria("140", "Veganos", "frio", "Pollo"));
        categorias.add(new Categoria("150", "Categoria 150", "seco", "diferentes presentaciones"));
        categorias.add(new Categoria( "160", "Categoria 160", "seco", "atún y conservas"));
        categorias.add(new Categoria( "170", "Categoria 170", "seco", "despensa "));
        categorias.add(new Categoria( "180", "Vegetales y Frutas", "frio", "despensa "));

        String sql ="";

        for (Categoria c:categorias) {
            sql=String.format("INSERT INTO CATEGORIA VALUES('%s','%s','%s','%s');",
                    c.getIdCategoria(),
                    c.getNombreCategoria(),
                    c.getAlmacenamiento(),
                    c.getObservacioes());

            this.mySqlOperation.myExecuteInsertUpdate(sql);
        }
    }


}
