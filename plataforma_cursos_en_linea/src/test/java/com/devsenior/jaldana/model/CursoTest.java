package com.devsenior.jaldana.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.devsenior.jaldana.exception.CursoLlenoException;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
public class CursoTest {

    @Test
    void testAgregarEstudianteCursoLleno() {
        // Creamos un curso con capacidad 2
        Curso curso = new Curso("CS101", "Introducción a la Programación", 2);
        curso.setEstudiantesInscritos(new ArrayList<>()); // Inicializamos la lista

        // Creamos estudiantes
        Estudiante e1 = new Estudiante("123", "Juan Pérez", "juan.perez@example.com");
        Estudiante e2 = new Estudiante("124", "María Gómez", "maria.gomez@example.com");
        Estudiante e3 = new Estudiante("125", "Luis Rodríguez", "luis.rodriguez@example.com");

        try {
            // Agregamos dos estudiantes, no debe lanzar excepción
            curso.agregarEstudiante(e1);
            curso.agregarEstudiante(e2);
        } catch (CursoLlenoException ex) {
            fail("No debería lanzar excepción aquí");
        }

        // Intentamos agregar un tercero: debe lanzar la excepción
        CursoLlenoException exception = assertThrows(CursoLlenoException.class, () -> {
            curso.agregarEstudiante(e3);
        });

        // Verificamos el mensaje de la excepción
        assertEquals("No se puede agregar el estudiante. El curso está lleno.", exception.getMessage());

        // Verificamos que solo hay 2 estudiantes en la lista
        assertEquals(2, curso.getEstudiantesInscritos().size());
    }

    @Test
    void testEstaLleno() throws CursoLlenoException {
        Curso curso = new Curso("CS102", "Algoritmos", 1);
        curso.setEstudiantesInscritos(new ArrayList<>());
        Estudiante e1 = new Estudiante("126", "Ana Torres", "ana.torres@example.com");

        // Antes de agregar, no está lleno
        assertFalse(curso.estaLleno());

        curso.agregarEstudiante(e1);

        // Después de agregar, debe estar lleno
        assertTrue(curso.estaLleno());
    }
}
