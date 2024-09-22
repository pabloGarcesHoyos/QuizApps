package com.example.autor_libro.controller;

import com.example.autor_libro.dto.AutorDto;
import com.example.autor_libro.Entity.Autor;
import com.example.autor_libro.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // Obtener un autor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Long id) {
        Autor autor = autorService.buscarAutor(id);
        return autor != null ? ResponseEntity.ok(autor) : ResponseEntity.notFound().build();
    }

    // Crear un nuevo autor
    @PostMapping
    public ResponseEntity<Autor> createAutor(@RequestBody AutorDto autorDto) {
        Autor nuevoAutor = autorService.crearAutor(autorDto);
        return ResponseEntity.ok(nuevoAutor);
    }

    // Actualizar un autor existente
    @PutMapping("/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable Long id, @RequestBody AutorDto autorDto) {
        if (autorService.actualizarAutor(id, autorDto)) {
            Autor autorActualizado = autorService.buscarAutor(id);
            return ResponseEntity.ok(autorActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un autor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        if (autorService.buscarAutor(id) != null) {
            autorService.eliminarAutor(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener todos los autores
    @GetMapping
    public ResponseEntity<List<Autor>> getAllAutores() {
        List<Autor> autores = autorService.findAll();
        return ResponseEntity.ok(autores);
    }
}
