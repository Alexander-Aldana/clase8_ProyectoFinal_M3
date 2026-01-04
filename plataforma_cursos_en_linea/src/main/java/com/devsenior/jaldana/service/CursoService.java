package com.devsenior.jaldana.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.*;

import com.devsenior.jaldana.exception.CursoNoencotradoException;
import com.devsenior.jaldana.model.Curso;


public class CursoService {
    private static final Logger logger = LogManager.getLogger(CursoService.class);
    private List<Curso> cursos;

    public CursoService() {
        this.cursos = new ArrayList<>(); //se inicializa con new arraylist
    }
    //agrgar curso
    public void agregarCurso(Curso curso) {
        cursos.add(curso);
        logger.info("Curso agregado: " + curso.getNombre());
    }
    //listar cursos
    public List<Curso> listarCursos() {
        return cursos;
    }
    //Buscar curso por codigo
    public Curso buscarCursoPorCodigo(String codigo) throws CursoNoencotradoException {//este es el codigo que el for va a iterar en la lista cursos
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) { //itea la lista de cursos hasta encontrar el codigo que se pidio
                return curso;
            }
        }
        logger.warn("Curso no encontrado con codigo: " + codigo);
        throw new CursoNoencotradoException("Curso con el codigo: " + "'"+ codigo+ "'" + " no encontrado."  );
    }
}
