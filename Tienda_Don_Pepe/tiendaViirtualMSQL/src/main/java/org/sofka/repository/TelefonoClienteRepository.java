package org.sofka.repository;

import com.github.javafaker.Faker;
import org.sofka.integration.database.mysql.MySqlOperation;
import org.sofka.model.TelefonoCliente;

import java.sql.SQLException;

public class TelefonoClienteRepository implements Table {

    private MySqlOperation mySqlOperation;
    private Faker faker;


    @Override
    public void generateData() throws SQLException {
        mySqlOperation = new MySqlOperation();
        mySqlOperation.configureDatabaseconetion();

        TelefonoCliente tc = new TelefonoCliente();
        String sql = "";
        faker = new Faker();

        for (int i = 200; i <= 250; i++) {
            tc.setTelefono(faker.phoneNumber().subscriberNumber(10));
            tc.setIdCliente(String.valueOf(i));

            sql = String.format("INSERT INTO TELEFONO_CLIENTE  VALUES('%s','%s');",
                    tc.getIdCliente(),
                    tc.getTelefono());
            System.out.println(sql);
            this.mySqlOperation.myExecuteInsertUpdate(sql);
        }
    }

}