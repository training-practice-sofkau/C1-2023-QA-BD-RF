package com.sofkau.mysql.repository;

import com.sofkau.mysql.ConexionMysql;
import com.sofkau.mysql.model.Servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ServiciosRepositoryImpl implements IRepository<Servicios> {
    private Connection getConnection() {
        return ConexionMysql.getConnection();
    }

    @Override
    public List<Servicios> findAll() {
        return null;
    }

    @Override
    public Servicios findById(Long id) {
        return null;
    }

    @Override
    public void save(Servicios value) {
        String sql = "INSERT INTO servicios (empleado_id, cliente_id, productos_consumidos, duracion_procedimiento, fecha)" +
                "VALUES (?,?,?,?,?);";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, value.getEmpleado_id());
            stmt.setInt(2, value.getCliente_id());
            stmt.setString(3, value.getProductos_consumidos());
            stmt.setDouble(4, value.getDuracion_procedimiento());
            stmt.setDate(5, new Date(value.getFecha().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

