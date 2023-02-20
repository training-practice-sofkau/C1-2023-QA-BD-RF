package org.sofka.repository;

import com.github.javafaker.Faker;
import org.sofka.integration.database.mysql.MySqlOperation;
import org.sofka.model.TelefonoProveedor;

import java.sql.SQLException;

public class TelefonoProveedorRepository implements  Table{

    private MySqlOperation mySqlOperation;
    private Faker faker;



    @Override
    public void generateData() throws SQLException {
        mySqlOperation = new MySqlOperation();
        mySqlOperation.configureDatabaseconetion();

        TelefonoProveedor tp = new TelefonoProveedor();
        String sql = "";
        faker = new Faker();

        for (int i = 100; i <= 150; i++) {
            tp.setIdproveedor(i);
            tp.setTelefono(faker.phoneNumber().subscriberNumber(10));

            sql = String.format("INSERT INTO TELEFONO_PROVEEEDOR  VALUES(%s,'%s');",
                    tp.getIdproveedor(),
                    tp.getTelefono());
            System.out.println(sql);
            this.mySqlOperation.myExecuteInsertUpdate(sql);
        }
    }
}
