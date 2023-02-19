package org.sofka.repository;

import com.github.javafaker.Faker;
import org.sofka.integration.database.mysql.MySqlOperation;
import org.sofka.model.TipoPago;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import static java.util.concurrent.TimeUnit.DAYS;

public class TipoPagoRepository implements Table {

    private MySqlOperation mySqlOperation;
    private Faker faker;

    @Override
    public void generateData() throws SQLException {
        mySqlOperation = new MySqlOperation();
        mySqlOperation.configureDatabaseconetion();
        TipoPago tp = new TipoPago();
        String sql ="";
        faker = new Faker();
        for (int i =1;i<=50;i++) {
            tp.setTipoPago( String.valueOf(i));
            tp.setNumerotarjeta(String.valueOf(faker.number().randomNumber(16,true)));
            tp.setFechaCaducidad(new SimpleDateFormat("dd-MM-yyyy").format((faker.date().future(3000, DAYS))));
            System.out.println(tp.getFechaCaducidad());
            sql = String.format("INSERT INTO TIPO_DE_PAGO  VALUES('%s','%s','%s');",
                    tp.getTipoPago(),
                    tp.getNumerotarjeta(),
                    tp.getFechaCaducidad());
            System.out.println(sql);
            this.mySqlOperation.myExecuteInsertUpdate(sql);
        }
    }
}
