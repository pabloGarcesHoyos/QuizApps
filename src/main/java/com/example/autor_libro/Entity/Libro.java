package com.example.autor_libro.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "genero")
    private String genero;

    @Column(name = "paginas")
    private int paginas;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    // Constructores
    public Libro() {
        super();
    }

    public Libro(Long id, String titulo, String genero, int paginas, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.autor = autor;
    }

    public Libro(String titulo, String genero, int paginas, Autor autor) {
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.autor = autor;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
