package com.example.autor_libro.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LibroDto {

    @NotNull(message = "El título no puede ser nulo")
    @Size(min = 1, max = 100, message = "El título debe tener entre 1 y 100 caracteres")
    private String titulo;

    @NotNull(message = "El género no puede ser nulo")
    @Size(min = 1, max = 50, message = "El género debe tener entre 1 y 50 caracteres")
    private String genero;

    @NotNull(message = "El autor no puede ser nulo")
    @Size(min = 1, max = 100, message = "El nombre del autor debe tener entre 1 y 100 caracteres")
    private String autor;

    public LibroDto() {
    }

    public LibroDto(String titulo, String genero, String autor) {
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
