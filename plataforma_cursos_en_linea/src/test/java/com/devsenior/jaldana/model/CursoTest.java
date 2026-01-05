package com.devsenior.jaldana.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CursoTest {


    @Test

        void testAgregarEstudiante() {
        // Implementar pruebas unitarias para el método agregarEstudiante  
        Curso curso = new Curso("CS101", "Introducción a la Programación", 2);
        Estudiante estudiante1 = new Estudiante("123", "Juan Pérez", "juan.perez@example.com");
        Estudiante estudiante2 = new Estudiante("124", "María Gómez", "maria.gomez@example.com");
        Estudiante estudiante3 = new Estudiante("125", "Luis Rodríguez", "luis.rodriguez@example.com");
        curso.agregarEstudiante(estudiante1);
        curso.agregarEstudiante(estudiante2);
        curso.agregarEstudiante(estudiante3); // Este debería fallar porque el cupo es 2

        assertEquals(estudiante2, estudiante3);
}
    
}
