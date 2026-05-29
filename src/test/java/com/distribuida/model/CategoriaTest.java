package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoriaTest {
    private Categoria categoria;

    @BeforeEach
    public void setUp() {
        categoria = new Categoria(
                1,
                "Cuento",
                "Caballero de la armadura Oxidada"
        );
    }
    @Test
    public void testCategoriaConstructorAndGetters() {
        assertAll("Pruebas unitarias - Constructor y Getters - Categoria",
                () -> assertEquals(1, categoria.getIdCategoria()),
                () -> assertEquals("Cuento", categoria.getCategoria()),
                () -> assertEquals("Caballero de la armadura Oxidada", categoria.getDescription())
        );
        System.out.println(categoria.toString());
    }

    @Test
    public void testCategoriaSetters() {
        categoria.setIdCategoria(2);
        categoria.setCategoria("Drama");
        categoria.setDescription("Cuento basado en hechos reales");

        assertAll("Pruebas unitarias - Setters - Categoria",
                () -> assertEquals(2, categoria.getIdCategoria()),
                () -> assertEquals("Drama", categoria.getCategoria()),
                () -> assertEquals("Cuento basado en hechos reales", categoria.getDescription())
        );
        System.out.println(categoria.toString());
    }

    }
