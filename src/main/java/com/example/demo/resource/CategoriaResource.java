package com.example.demo.resource;



import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource{
    private final CategoriaService categoriaServices;

    public CategoriaResource(CategoriaService categoriaServices) {
        this.categoriaServices = categoriaServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Categoria>> findAllCategorias(){
        List<Categoria> categorias = categoriaServices.findAllCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Categoria> findCategoriaById(@PathVariable("id") Long id){
        Categoria categoria = categoriaServices.findCategoriaById(id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Categoria> addCategoria(@RequestBody Categoria categoria){
        Categoria newCategoria = categoriaServices.addCategoria(categoria);
        return new ResponseEntity<>(newCategoria, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria,@PathVariable("id") Long id){
        Categoria updateCategoria = categoriaServices.updateCategoria(categoria, id);
        return new ResponseEntity<>(updateCategoria, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Categoria> deleteCategoria(@PathVariable("id") Long id){
        categoriaServices.deleteCategoria(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

