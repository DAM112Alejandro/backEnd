package com.example.demo.repo;


import com.example.demo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface AutorRepo extends JpaRepository<Autor, String> {
   void deleteAutorByDni(String dni);


   Optional<Autor> getBydni(String dni);
}
