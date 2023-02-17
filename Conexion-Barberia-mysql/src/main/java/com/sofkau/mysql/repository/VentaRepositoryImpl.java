package com.sofkau.mysql.repository;

import com.sofkau.mysql.ConexionMysql;
import com.sofkau.mysql.model.Cita;
import com.sofkau.mysql.model.Ventas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class VentaRepositoryImpl implements IRepository<Ventas> {

    private Connection getConnection() {
        return ConexionMysql.getConnection();
    }

    @Override
    public List<Ventas> findAll() {
        return null;
    }

    @Override
    public Ventas findById(Long id) {
        return null;
    }

    @Override
    public void save(Ventas value) {
        String sql = "INSERT INTO ventas (empleado_id, cliente_id, producto_id, fecha,liga_ganancia)" +
                "VALUES (?,?, ?, ?,?);";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1,value.getEmpleadoId());
            stmt.setInt(2, value.getClienteId());
            stmt.setInt(3, value.getProductoId());
            stmt.setDate(4, new Date(value.getFecha().getTime()));
            stmt.setDouble(5, value.getLigaGanancia());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


