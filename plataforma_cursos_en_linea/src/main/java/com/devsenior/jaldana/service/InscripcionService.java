package com.devsenior.jaldana.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;

import com.devsenior.jaldana.exception.CursoLlenoException;
import com.devsenior.jaldana.exception.EstudianteNoEncontadoException;
import com.devsenior.jaldana.model.Curso;
import com.devsenior.jaldana.model.Estudiante;
import com.devsenior.jaldana.model.Inscripcion;

public class InscripcionService {
   
   private static final Logger logger = LogManager.getLogger(InscripcionService.class);
   
    //coleccion de inscripciones

private List<Inscripcion> inscripciones;

   public InscripcionService() {
       this.inscripciones = new ArrayList<>();
    }

    public void inscribirEstudiante(Curso curso, Estudiante estudiante) throws CursoLlenoException {
       if (curso.estaLleno()) {
        logger.error("Intento de inscripcion fallido: curso lleno {} en el curso {}: cupo lleno.", curso.getNombre());
        throw new CursoLlenoException("El curso " + curso.getNombre() + "esta lleno. Nse puede inscribir al curso");
       }
       curso.agregarEstudiante(estudiante);
       Inscripcion inscripcion = new Inscripcion (estudiante, curso);
       inscripciones.add(inscripcion);
       logger.info("Estudiante {} inscrito exitosamente en el curso {}.", estudiante.getNombre(), curso.getNombre());
    }

    public List<Inscripcion> buscarInscripcionesPorEstudiante(Estudiante estudiante) throws EstudianteNoEncontadoException {
        
        //creamos una lista para guardar las inscripciones del estudiante
        List<Inscripcion> inscripcionesDelEstudiante = new ArrayList<>();

        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getEstudiante().getId().equals(estudiante.getId())) {
                inscripcionesDelEstudiante.add(inscripcion);
            }
        }

        //si no encontramos inscripciones, registramos un aviso en el log
        if (inscripcionesDelEstudiante.isEmpty()) {
            logger.warn("No se encontraron inscripciones para el estudiante {}.", estudiante.getId());
            throw new EstudianteNoEncontadoException("No se encontraron inscripciones para el estudiante: " + estudiante.getNombre() +"con el ID: "+ estudiante.getId());
        } else {
            logger.info("Se encontraron {} inscripciones para el estudiante {}.", inscripcionesDelEstudiante.size(), estudiante.getNombre());
        }

        return inscripcionesDelEstudiante;

    }
}
