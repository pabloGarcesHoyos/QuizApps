package com.example.autor_libro.service;

import com.example.autor_libro.dto.AutorDto;
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

    public boolean eliminarAutor(Long id) {
        autorRepository.deleteById(id);
        return true;
    }

    public Autor buscarAutor(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    public Autor crearAutor(AutorDto autorDto) {
        Autor autor = new Autor();
        autor.setNombre(autorDto.getNombre());
        autor.setApellido(autorDto.getApellido());
        return autorRepository.save(autor);
    }

    public boolean actualizarAutor(Long id, AutorDto autorDto) {
        Optional<Autor> optionalAutor = autorRepository.findById(id);

        if (optionalAutor.isPresent()) {
            Autor autorAActualizar = optionalAutor.get();
            autorAActualizar.setNombre(autorDto.getNombre());
            autorAActualizar.setApellido(autorDto.getApellido());
            autorRepository.save(autorAActualizar);
            return true;
        } else {
            return false;
        }
    }

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }
}
