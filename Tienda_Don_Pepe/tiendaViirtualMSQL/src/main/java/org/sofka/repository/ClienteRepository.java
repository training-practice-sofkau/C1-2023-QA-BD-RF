package org.sofka.repository;

import com.github.javafaker.Faker;
import org.sofka.integration.database.mysql.MySqlOperation;
import org.sofka.model.Cliente;

import java.sql.SQLException;

public class ClienteRepository implements Table {
    private MySqlOperation mySqlOperation;
    private Faker faker;

    @Override
    public void generateData() throws SQLException {
        mySqlOperation = new MySqlOperation();
        mySqlOperation.configureDatabaseconetion();
        Cliente c = new Cliente();
        String sql = "";
        faker = new Faker();
        for (int i = 200; i <= 250; i++) {
            c.setId(String.valueOf(i));
            c.setCedula(String.valueOf(faker.idNumber().valid().replace("-","")));
            c.setNombre(faker.name().fullName());
            c.setEmail((faker.funnyName().name()+ "@gmail.com").replace(" ",""));
            c.setPassword(String.valueOf(faker.number()));
            c.setZonaPostal(String.valueOf(i));

            sql = String.format("INSERT INTO CLIENTE VALUES('%s','%s','%s','%s','%s','%s');",
                    c.getId(),
                    c.getCedula(),
                    c.getNombre(),
                    c.getEmail(),
                    c.getPassword(),
                    c.getZonaPostal());
            System.out.println(sql);
            this.mySqlOperation.myExecuteInsertUpdate(sql);
        }
    }
}