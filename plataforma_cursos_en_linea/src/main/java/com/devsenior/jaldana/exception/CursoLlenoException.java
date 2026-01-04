package com.devsenior.jaldana.exception;

public class CursoLlenoException extends Exception {
    public CursoLlenoException(String mensaje) {
        super(mensaje);
    }
public CursoLlenoException (String mensaje, Throwable cause) {
        super(mensaje, cause);
    }
}
