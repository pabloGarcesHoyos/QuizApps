package com.example.autor_libro.service;

import com.example.autor_libro.Entity.Autor;
import com.example.autor_libro.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Optional<Autor> findById(Long id) {
        return autorRepository.findById(id);
    }

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public void deleteById(Long id) {
        autorRepository.deleteById(id);
    }

    public Optional<Autor> update(Autor autor) {
        return autorRepository.findById(autor.getId()).map(existingAutor -> {
            autor.setId(existingAutor.getId());
            Autor savedAutor = autorRepository.save(autor);
            return savedAutor;
        });
    }

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }
}
