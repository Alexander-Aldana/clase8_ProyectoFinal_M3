package com.devsenior.jaldana;

import com.devsenior.jaldana.exception.CursoLlenoException;
import com.devsenior.jaldana.model.Curso;
import com.devsenior.jaldana.model.Estudiante;
import com.devsenior.jaldana.service.CursoService;
import com.devsenior.jaldana.service.InscripcionService;
import org.apache.logging.log4j.*;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
    
        CursoService cursoService = new CursoService();
        InscripcionService inscripcionService = new InscripcionService();

        //crear cursos
        Curso javaBasico = new Curso("C001", "Java Básico", 2);
        Curso pythonIntermedio = new Curso("C002", "Python Intermedio", 4);
        
        cursoService.agregarCurso(javaBasico);
        cursoService.agregarCurso(pythonIntermedio);

        //Crear estudinates
        Estudiante estudiante1 = new Estudiante("E001", "Ana Pérez","nana@gmail.com");
        Estudiante estudiante2 = new Estudiante("E002", "Luis Gómez","luis@gmail.com");
        Estudiante estudiante3 = new Estudiante("E003", "Marta Ruiz","marta@gmail.com");

        //Inscripciones con manejo de excepciones
        try {
            inscripcionService.inscribirEstudiante(javaBasico, estudiante1);
            inscripcionService.inscribirEstudiante(javaBasico, estudiante2);
            inscripcionService.inscribirEstudiante(pythonIntermedio, estudiante3);
            inscripcionService.inscribirEstudiante(javaBasico, estudiante3); //deberia fallar por cupo lleno
        } catch (CursoLlenoException e) {
            logger.error("Error de inscripción: " + e.getMessage());
        }
        
        //Mostrar cursos y estudiantes inscritos
        System.out.println("---cursos disponibles---");
        for (Curso curso : cursoService.listarCursos()) {
            System.out.println(curso);
            System.out.println("Estudiantes inscritos:");
            for (Estudiante est : curso.getEstudiantesInscritos()) {
                System.out.println("- " + est);
            }
        }
    }
}