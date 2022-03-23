package com.example.demo.repo;


import com.example.demo.model.Libro;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;


public interface LibroRepo extends JpaRepository<Libro, Long> {


    Optional<Libro> findLibroById(Long id);
    

    List<Libro> findAllLibroByAutorDni(String dni);


    List<Libro> findLibroByCategoriaId(Long id);
}
