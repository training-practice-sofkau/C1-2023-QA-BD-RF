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
        categorias.add(new Categoria("10", "Aseo Personal", "seco", "cuidado personal"));
        categorias.add(new Categoria( "20", "Bebidas", "frio", "gaseosa"));
        categorias.add(new Categoria("30", "Lacteos", "frio", "Queso "));
        categorias.add(new Categoria("40", "Carnes", "frio", "Pollo"));
        categorias.add(new Categoria("50", "Arroz y granos", "seco", "diferentes presentaciones"));
        categorias.add(new Categoria( "60", "enlatados", "seco", "atún y conservas"));
        categorias.add(new Categoria( "70", "condimentos", "seco", "despensa "));
        categorias.add(new Categoria( "80", "Vegetales y Frutas", "frio", "despensa "));

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
