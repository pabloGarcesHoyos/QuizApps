package com.example.autor_libro.controller;

import com.example.autor_libro.Entity.Libro;
import com.example.autor_libro.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        Optional<Libro> libro = libroService.findById(id);
        return libro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        return libroService.save(libro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro libroDetails) {
        Optional<Libro> libro = libroService.findById(id);

        if (libro.isPresent()) {
            Libro updatedLibro = libro.get();
            updatedLibro.setTitulo(libroDetails.getTitulo());
            updatedLibro.setAutor(libroDetails.getAutor());
            return ResponseEntity.ok(libroService.save(updatedLibro));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un libro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        if (libroService.findById(id).isPresent()) {
            libroService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.findAll();
    }
}
