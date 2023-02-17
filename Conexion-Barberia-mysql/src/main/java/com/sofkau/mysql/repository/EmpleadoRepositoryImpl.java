package com.sofkau.mysql.repository;

import com.sofkau.mysql.ConexionMysql;
import com.sofkau.mysql.model.Empleado;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmpleadoRepositoryImpl implements IRepository<Empleado> {

    private Connection getConnection() {
        return ConexionMysql.getConnection();
    }
    @Override
    public List<Empleado> findAll() {
        return null;
    }

    @Override
    public Empleado findById(Long id) {
        return null;
    }

    @Override
    public void save(Empleado value) {
        String sql = "INSERT INTO empleados (cedula, nombre, especialidad)" +
                "VALUES (?,?,?);";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, value.getCedula());
            stmt.setString(2, value.getNombre());
            stmt.setString(3, value.getEspecialidad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
