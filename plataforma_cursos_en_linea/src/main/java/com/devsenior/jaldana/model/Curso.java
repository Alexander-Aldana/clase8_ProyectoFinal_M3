package com.devsenior.jaldana.model;

import java.util.List;

public class Curso {
    //atributos: codigo, nombre, capacidad, estudiantes inscritos
    private String codigo;
    private String nombre;
    private int capacidad;
    private List<Estudiante> estudiantesInscritos; 

    public Curso(String codigo, String nombre, int capacidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<Estudiante> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    public void setEstudiantesInscritos(List<Estudiante> estudiantesInscritos) {
        this.estudiantesInscritos = estudiantesInscritos;
    }

    public boolean estaLleno() {
        return estudiantesInscritos.size() >= capacidad;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (!estaLleno()) {
            estudiantesInscritos.add(estudiante);
        }
    }
    @Override
    public String toString() {
        return "Curso{" + "Codigo= '" + codigo + '\'' + ", Nombre= '" + nombre + '\'' + ", Capacidad= " + capacidad + ", estudiantes Inscritos= " + estudiantesInscritos + '}';
    }
    
}
