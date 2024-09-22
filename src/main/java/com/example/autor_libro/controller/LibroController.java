package com.example.autor_libro.controller;

import com.example.autor_libro.dto.LibroDto;
import com.example.autor_libro.Entity.Libro;
import com.example.autor_libro.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // Obtener un libro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        Libro libro = libroService.buscarLibro(id);
        if (libro != null) {
            return ResponseEntity.ok(libro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un libro
    @PostMapping
    public ResponseEntity<Libro> createLibro(@RequestBody LibroDto libroDto) {
        try {
            Libro nuevoLibro = libroService.crearLibro(libroDto);
            return ResponseEntity.ok(nuevoLibro);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Actualizar un libro
    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody LibroDto libroDto) {
        try {
            boolean actualizado = libroService.actualizarLibro(id, libroDto);
            if (actualizado) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Eliminar un libro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        Libro libro = libroService.buscarLibro(id);
        if (libro != null) {
            libroService.eliminarLibro(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener todos los libros
    @GetMapping
    public ResponseEntity<List<Libro>> getAllLibros() {
        List<Libro> libros = libroService.findAll();
        return ResponseEntity.ok(libros);
    }
}
