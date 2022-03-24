package com.example.demo.resource;

import com.example.demo.dto.dtoLibros;
import com.example.demo.model.Autor;
import com.example.demo.model.Libro;
import com.example.demo.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Component
@RestController
@RequestMapping("/libro")
public class LibroResource {
    private final LibroService libroServices;

    public LibroResource(LibroService libroServices){
        this.libroServices = libroServices;
    }
    @GetMapping("/all")
    public ResponseEntity<List<dtoLibros>> findAllLibros(){
        List<Libro> libros = libroServices.findAllLibros();
        List<dtoLibros>librosCA=new ArrayList<>();
        for (int i=0; i<libros.size();i++){
            if (libros.get(i).getAutor() == null){
                libros.get(i).setAutor(new Autor());
            }
            librosCA.add(new dtoLibros());
            librosCA.get(i).setId(libros.get(i).getId());
            librosCA.get(i).setTitulo(libros.get(i).getTitulo());
            librosCA.get(i).setEdicion(libros.get(i).getEdicion());
            librosCA.get(i).setAutor(libros.get(i).getAutor().getNombre()+" "+libros.get(i).getAutor().getApellido1());
            librosCA.get(i).setCategoria(libros.get(i).getCategoria().getDescripcion());
        }

        return new ResponseEntity<>(librosCA, HttpStatus.OK);
    }
    @GetMapping("getById/{id}")
    public ResponseEntity<Libro> findLibroById(@PathVariable("id") Long id){
        Libro libro = libroServices.findLibroById(id);
        return new ResponseEntity<>(libro, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Libro> addLibro(@RequestBody Libro libro){
        Libro newLibro = libroServices.addLibro(libro);
        return new ResponseEntity<>(newLibro, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Libro> updateLibro(@RequestBody Libro libro, Long id){
        Libro updateLibro = libroServices.updateLibro(libro, id);
        return new ResponseEntity<>(updateLibro, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Libro> deleteLibro(@PathVariable("id") Long id){
        libroServices.deleteLibro(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/autor/{dni}")
 public ResponseEntity<List<Libro>> findLibroByAutorId(@PathVariable("dni") String dni){
    List<Libro> newlibro=libroServices.findLibroByAutorDni(dni);
    return new ResponseEntity<>(newlibro, HttpStatus.CREATED);

    }
    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Libro>> findLibroByCategoriaId(@PathVariable("id") Long id){
        List<Libro> libros = libroServices.findLibroByCategoriaId(id);
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }
}
