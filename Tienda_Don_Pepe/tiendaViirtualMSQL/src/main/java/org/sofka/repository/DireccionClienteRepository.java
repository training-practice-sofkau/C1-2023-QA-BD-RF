package org.sofka.repository;

import com.github.javafaker.Faker;
import org.sofka.integration.database.mysql.MySqlOperation;
import org.sofka.model.DireccioncCliente;

import java.sql.SQLException;

public class DireccionClienteRepository implements Table {
    private MySqlOperation mySqlOperation;
    private Faker faker;


    @Override
    public void generateData() throws SQLException {
        mySqlOperation = new MySqlOperation();
        mySqlOperation.configureDatabaseconetion();
        DireccioncCliente dc = new DireccioncCliente();
        String sql = "";
        faker = new Faker();

        for (int i = 200; i <= 250; i++) {
            dc.setId(i);
            dc.setNumero(faker.address().buildingNumber());
            dc.setCalle(faker.address().streetName());
            dc.setBarrio(faker.address().streetName());
            dc.setIdCliente(String.valueOf(i));

            sql = String.format("INSERT INTO DIRECCION_CLIENTE  VALUES('%s','%s','%s','%s','%s');",
                    dc.getId(),
                    dc.getNumero(),
                    dc.getCalle(),
                    dc.getBarrio(),
                    dc.getIdCliente());
            System.out.println(sql);
            this.mySqlOperation.myExecuteInsertUpdate(sql);
        }

    }
}