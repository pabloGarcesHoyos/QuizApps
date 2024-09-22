package com.example.autor_libro.service;

import com.example.autor_libro.dto.LibroDto;
import com.example.autor_libro.Entity.Libro;
import com.example.autor_libro.Entity.Autor;
import com.example.autor_libro.repository.LibroRepository;
import com.example.autor_libro.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public boolean eliminarLibro(Long id) {
        libroRepository.deleteById(id);
        return true;
    }

    public Libro buscarLibro(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    public Libro crearLibro(LibroDto libroDto) {
        Libro libro = new Libro();
        libro.setTitulo(libroDto.getTitulo());
        libro.setGenero(libroDto.getGenero());

        Optional<Autor> autorOptional = autorRepository.findByNombre(libroDto.getAutor());
        if (autorOptional.isPresent()) {
            libro.setAutor(autorOptional.get());
        } else {
            throw new RuntimeException("Autor no encontrado");
        }

        return libroRepository.save(libro);
    }

    public boolean actualizarLibro(Long id, LibroDto libroDto) {
        Optional<Libro> optionalLibro = libroRepository.findById(id);

        if (optionalLibro.isPresent()) {
            Libro libroAActualizar = optionalLibro.get();
            libroAActualizar.setTitulo(libroDto.getTitulo());
            libroAActualizar.setGenero(libroDto.getGenero());

            Optional<Autor> autorOptional = autorRepository.findByNombre(libroDto.getAutor());
            if (autorOptional.isPresent()) {
                libroAActualizar.setAutor(autorOptional.get());
            } else {
                throw new RuntimeException("Autor no encontrado");
            }

            libroRepository.save(libroAActualizar);
            return true;
        } else {
            return false;
        }
    }

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }
}
