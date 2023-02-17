package com.sofkau.mysql.repository;

import com.sofkau.mysql.ConexionMysql;
import com.sofkau.mysql.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryImpl implements IRepository<Producto> {

    private Connection getConnection() {
        return ConexionMysql.getConnection();
    }

    @Override
    public List<Producto> findAll() {
        List<Producto> productos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM productos")
        ) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setRef(rs.getLong("REF"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setProveedor(rs.getString("proveedor"));
                productos.add(producto);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productos;
    }

    @Override
    public Producto findById(Long id) {
        return null;
    }

    @Override
    public void save(Producto value) {
        String sql = "INSERT INTO productos (`nombre`, `cantidad`, `precio`, `proveedor`) VALUES (?,? ,? ,?  );";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql)) {
        stmt.setString(1, value.getNombre());
        stmt.setInt(2, value.getCantidad());
        stmt.setDouble(3, value.getPrecio());
        stmt.setString(4, value.getProveedor());

        stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
