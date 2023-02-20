package org.sofka.repository;

import com.github.javafaker.Faker;
import org.sofka.integration.database.mysql.MySqlOperation;
import org.sofka.model.Producto;

import java.sql.SQLException;

public class ProductoRepository implements Table{

    private MySqlOperation mySqlOperation;
    private Faker faker;

    @Override
    public void generateData() throws SQLException {

        mySqlOperation = new MySqlOperation();
        mySqlOperation.configureDatabaseconetion();
        Producto p = new Producto();
        String sql = "";
        faker = new Faker();

        for (int i = 100; i <= 150; i++) {
            p.setId(String.valueOf(i));
            p.setNombre(faker.food().fruit());
            p.setOrigen(obtenerorigen());
            p.setMarca(faker.company().name().replace("'"," "));
            p.setPeso(String.valueOf(faker.number().randomDouble(2,1, 10)));
            p.setStock(faker.number().numberBetween(10,1000));
            p.setPrecio(String.valueOf(faker.number().randomDouble(2,1000, 50000)));
            p.setIdProveeedor(i);
            p.setIdCategoria("80");

            sql = String.format("INSERT INTO PRODUCTO  VALUES('%s','%s','%s','%s','%s',%s,'%s',%s,'%s');",
                    p.getId(),
                    p.getNombre(),
                    p.getOrigen(),
                    p.getMarca(),
                    p.getPeso(),
                    p.getStock(),
                    p.getPrecio(),
                    p.getIdProveeedor(),
                    p.getIdCategoria());
            System.out.println(sql);
            this.mySqlOperation.myExecuteInsertUpdate(sql);
        }
    }

    public String obtenerorigen(){
        String origen ="Nacional";
        faker = new Faker();
        if(faker.number().numberBetween(1,10) >5){
            origen ="Importado";
        }
        return origen;
    }

}
