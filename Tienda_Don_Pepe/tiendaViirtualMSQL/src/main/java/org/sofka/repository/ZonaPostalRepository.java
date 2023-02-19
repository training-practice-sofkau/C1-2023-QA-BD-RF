package org.sofka.repository;

import com.github.javafaker.Faker;
import org.sofka.integration.database.mysql.MySqlOperation;
import org.sofka.model.ZonaPostal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZonaPostalRepository implements Table{
    private MySqlOperation mySqlOperation;
    private Faker faker;
    @Override
    public void generateData() throws SQLException {
        mySqlOperation = new MySqlOperation();
        mySqlOperation.configureDatabaseconetion();
        ZonaPostal zp = new ZonaPostal();
        String sql ="";
        faker = new Faker();
        for (int i =200;i<=250;i++) {
            zp.setId( String.valueOf(i));
            zp.setZonaPostal(faker.address().cityName());
            zp.setCodigoPostal(faker.address().zipCode());
            sql = String.format("INSERT INTO ZONA_POSTAL VALUES('%s','%s','%s');",
                    zp.getId(),
                    zp.getZonaPostal(),
                    zp.getCodigoPostal());
            System.out.println(sql);
            this.mySqlOperation.myExecuteInsertUpdate(sql);
        }

    }

    public List<String> obtenerZonaPorId(String id) throws SQLException {
            List<String> lZona = new ArrayList<String>();
            String sql = "";
            mySqlOperation = new MySqlOperation();
            mySqlOperation.configureDatabaseconetion();
            sql = String.format("SELECT * FROM ZONA_POSTAL WHERE  id_zona_postal='%s';",id);
           System.out.println(sql);
           mySqlOperation.myExecuteQuery(sql);
          System.out.println(mySqlOperation.getResultset().getMetaData());
           int j = mySqlOperation.getResultset().getMetaData().getColumnCount();
          System.out.println(j);
          if (mySqlOperation.getResultset().next()){
            for (int i=1;i <=j;i++) {
                String str = mySqlOperation.getResultset().getString(i);
                lZona.add(str);
            }}
            mySqlOperation.close();
        return lZona;
    }

}
