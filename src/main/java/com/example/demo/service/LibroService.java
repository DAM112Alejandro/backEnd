package com.example.demo.service;

import com.example.demo.model.Libro;
import com.example.demo.repo.LibroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class LibroService {

    private final LibroRepo libroRepo;


    @Autowired
    public LibroService(LibroRepo libroRepo) {
        this.libroRepo = libroRepo;
    }

    public List<Libro> findAllLibros() {
        return libroRepo.findAll();
    }

    public Libro findLibroById(Long id) {
        return libroRepo.findLibroById(id).orElseThrow(() -> new IllegalArgumentException("libro not found"));
    }


    public void deleteLibro(Long id) {
        libroRepo.deleteById(id);
    }

    public Libro updateLibro(Libro libro, Long id) {
        if (libroRepo.findLibroById(id).isPresent()) {
            libro.setId(id);
            return libroRepo.save(libro);
        } else {
            return null;
        }
    }




    public Libro addLibro(Libro libro) {
            return libroRepo.save(libro);

    }

    public List<Libro> findLibroByCategoriaId(Long id) {
        return libroRepo.findLibroByCategoriaId(id);
    }

    public List<Libro> findLibroByAutorDni(String dni) {
        return  libroRepo.findAllLibroByAutorDni(dni);
    }
}



