package org.sofka.repository;

import com.github.javafaker.Faker;
import org.sofka.integration.database.mysql.MySqlOperation;
import org.sofka.model.Proveedor;

import java.sql.SQLException;

public class ProveedorRepository implements Table {
    private MySqlOperation mySqlOperation;
    private Faker faker;

    @Override
    public void generateData() throws SQLException {
        mySqlOperation = new MySqlOperation();
        mySqlOperation.configureDatabaseconetion();
        Proveedor p = new Proveedor();
        String sql = "";
        faker = new Faker();

        for (int i = 100; i <= 150; i++) {
            p.setId(i);
            p.setNombre(faker.company().name().replace("'"," "));
            p.setDireccion(faker.address().fullAddress().replace("'"," "));
            p.setTelefono(faker.phoneNumber().subscriberNumber(10));

            sql = String.format("INSERT INTO PROVEEDOR  VALUES(%s,'%s','%s','%s');",
                    p.getId(),
                    p.getNombre(),
                    p.getDireccion(),
                    p.getTelefono());
            System.out.println(sql);
            this.mySqlOperation.myExecuteInsertUpdate(sql);
        }

    }

}
