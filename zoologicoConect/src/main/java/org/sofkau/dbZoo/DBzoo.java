package org.sofkau.dbZoo;

import java.sql.ResultSet;
import java.sql.SQLException;
public interface DBzoo {

        public void configureDataBaseConnection();
        public void executeSqlStatement();
        public ResultSet  getResulset();
        public void close();
        public  void printResulset() throws SQLException;
}