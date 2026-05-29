package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutorTest {

    private Autor autor;

    @BeforeEach
    public void setUp() {
        autor = new Autor(
                1,
                "Emerson",
                "Perugachi Zarchi",
                "Ecuador",
                "Unidad Nacional",
                "09999728741",
                "perugachi@correo.com"
        );
    }

    @Test
    public void testAutorConstructorAndGetters() {

        assertAll("Pruebas unitarias - Constructor y Getters - Autor",

                () -> assertEquals(1, autor.getIdAutor()),
                () -> assertEquals("Emerson", autor.getNombre()),
                () -> assertEquals("Perugachi Zarchi", autor.getApellido()),
                () -> assertEquals("Ecuador", autor.getPais()),
                () -> assertEquals("Unidad Nacional", autor.getDireccion()),
                () -> assertEquals("09999728741", autor.getTelefono()),
                () -> assertEquals("perugachi@correo.com", autor.getCorreo())
        );

        System.out.println(autor.toString());
    }

    @Test
    public void testAutorSetters() {

        autor.setIdAutor(2);
        autor.setNombre("Alex");
        autor.setApellido("Perugachi Zarchi");
        autor.setPais("Ecuador");
        autor.setDireccion("Unidad Nacional");
        autor.setTelefono("0986374121");
        autor.setCorreo("alex@correo.com");

        assertAll("Pruebas unitarias - Setters - Autor",

                () -> assertEquals(2, autor.getIdAutor()),
                () -> assertEquals("Alex", autor.getNombre()),
                () -> assertEquals("Perugachi Zarchi", autor.getApellido()),
                () -> assertEquals("Ecuador", autor.getPais()),
                () -> assertEquals("Unidad Nacional", autor.getDireccion()),
                () -> assertEquals("0986374121", autor.getTelefono()),
                () -> assertEquals("alex@correo.com", autor.getCorreo())
        );

        System.out.println(autor.toString());
    }

    @Test
    public void testAutorToString() {

        String str = autor.toString();

        assertAll("Pruebas unitarias - ToString - Autor",

                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("Emerson")),
                () -> assertTrue(str.contains("Perugachi Zarchi")),
                () -> assertTrue(str.contains("Ecuador")),
                () -> assertTrue(str.contains("Unidad Nacional")),
                () -> assertTrue(str.contains("09999728741")),
                () -> assertTrue(str.contains("perugachi@correo.com"))
        );
    }
}