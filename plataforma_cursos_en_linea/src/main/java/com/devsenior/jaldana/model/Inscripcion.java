package com.devsenior.jaldana.model;

import java.time.LocalDate;

public class Inscripcion {
//Estudiante, curso, fecha de inscripcion
    private Estudiante estudiante;
    private Curso curso;
    private LocalDate fechaInscripcion;

    public Inscripcion (Estudiante estudiante, Curso curso) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.fechaInscripcion = LocalDate.now();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    @Override
    public String toString() {
        return "Inscripcion{" + "estudiante=" + estudiante + ", curso=" + curso + ", fechaInscripcion=" + fechaInscripcion +'}';
    }
    
}
