package com.example.autor_libro.service;

import com.example.autor_libro.Entity.Libro;
import com.example.autor_libro.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }

    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }

    public Optional<Libro> update(Libro libro) {
        return libroRepository.findById(libro.getId()).map(existingLibro -> {
            libro.setId(existingLibro.getId());
            Libro savedLibro = libroRepository.save(libro);
            return savedLibro;
        });
    }

    // Obtener todos los libros
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }
}
