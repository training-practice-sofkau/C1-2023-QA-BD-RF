package org.sofka;

import org.sofka.repository.CategoriaRepository;

import java.sql.SQLException;

public class Main {
    private static CategoriaRepository categoriaRepository;

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");

        // Genera registros de categorias
        categoriaRepository = new CategoriaRepository();
        categoriaRepository.generateData();


    }
}