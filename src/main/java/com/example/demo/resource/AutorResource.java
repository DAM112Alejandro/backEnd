package com.example.demo.resource;

import com.example.demo.model.Autor;
import com.example.demo.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.*;
import java.util.List;
@Component
@RestController
@RequestMapping("/autor")
public class AutorResource {
    private final AutorService autorServices;

    public AutorResource(AutorService autorServices) {
        this.autorServices = autorServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Autor>> getAllAutors(){
        List<Autor> autors = autorServices.findAllAutors();
        return new ResponseEntity<>(autors, HttpStatus.OK);
    }
    @GetMapping("/getById/{dni}")
    public ResponseEntity<Autor> getAutorsById(@PathVariable("dni") String dni){
        Autor autor = autorServices.findAutorByDni(dni);
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Autor> addAutor(@RequestBody Autor autor){
        Autor newAutor = autorServices.addAutor(autor);
        return new ResponseEntity<>(newAutor, HttpStatus.CREATED);
    }
    @PutMapping("/update/{dni}")
    public ResponseEntity<Autor> updateAutor(@RequestBody Autor autor, String dni){
        Autor updateAutor = autorServices.updateAutor(autor, dni);
        return new ResponseEntity<>(updateAutor, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{dni}")
    public ResponseEntity<Autor> deleteAutor(@PathVariable("dni") String dni){
        autorServices.deleteAutor(dni);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

