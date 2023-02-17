package com.sofkau.mysql.repository;

import com.sofkau.mysql.ConexionMysql;
import com.sofkau.mysql.model.Cita;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CitaRepositoryImpl implements IRepository<Cita>{

    private Connection getConnection() {
        return ConexionMysql.getConnection();
    }
    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Cita findById(Long id) {
        return null;
    }

    @Override
    public void save(Cita value) {
        String sql =  "INSERT INTO citas (cliente_id, empleado_id, fecha_hora) " +
                "VALUES (?, ?, ?)";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, value.getCliente());
            stmt.setInt(2, value.getEmpleado());
           stmt.setDate(3,new Date(value.getFechaHora().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
