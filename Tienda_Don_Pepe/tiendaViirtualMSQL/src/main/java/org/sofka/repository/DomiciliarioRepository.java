package org.sofka.repository;

import com.github.javafaker.Faker;
import org.sofka.integration.database.mysql.MySqlOperation;
import org.sofka.model.Domiciliario;

import java.sql.SQLException;
import java.util.List;

public class DomiciliarioRepository implements Table {
    private MySqlOperation mySqlOperation;
    private Faker faker;


    @Override
    public void generateData() throws SQLException {
        mySqlOperation = new MySqlOperation();
        mySqlOperation.configureDatabaseconetion();
        Domiciliario d = new Domiciliario();
        ZonaPostalRepository zp = new ZonaPostalRepository();
        String sql = "";
        faker = new Faker();
        for (int i = 200; i <= 250; i++) {
            d.setId(String.valueOf(i));
            d.setNombre(faker.superhero().name());
            d.setMatricula(faker.phoneNumber().subscriberNumber(6));
            d.setIdZonapostal(String.valueOf(i));

            List<String> zonapostal= zp.obtenerZonaPorId(String.valueOf(i));
            d.setZonaReparto(zonapostal.get(1));

            sql = String.format("INSERT INTO  DOMICILIARIO VALUES('%s','%s','%s','%s','%s');",
                    d.getId(),
                    d.getNombre(),
                    d.getMatricula(),
                    d.getZonaReparto(),
                    d.getIdZonapostal());
            System.out.println(sql);
            this.mySqlOperation.myExecuteInsertUpdate(sql);
        }



    }
}
