package com.sofkau.mysql.repository;
import com.sofkau.mysql.ConexionMysql;
import com.sofkau.mysql.model.Cliente;
import java.sql.*;
import java.util.List;



public class ClienteRepositoryImpl implements IRepository<Cliente> {
    private Connection getConnection() {
        return ConexionMysql.getConnection();
    }
    @Override
    public List<Cliente> findAll() {
        return null;
    }

    @Override
    public Cliente findById(Long id) {
        return null;
    }

    @Override
    public void save(Cliente value) {
        String sql = "INSERT INTO clientes (cedula, nombre, profesion, telefono, correo, edad, direccion) " +
                "VALUES (?,?,?,?,?,? ,? );";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, value.getCedula());
            stmt.setString(2, value.getNombre());
            stmt.setString(3, value.getProfesion());
            stmt.setString(4, value.getTelefono());
            stmt.setString(5, value.getCorreo());
            stmt.setInt(6, value.getEdad());
            stmt.setString(7, value.getDireccion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


