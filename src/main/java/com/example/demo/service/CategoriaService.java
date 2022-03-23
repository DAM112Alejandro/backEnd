package com.example.demo.service;

import com.example.demo.model.Categoria;
import com.example.demo.repo.CategoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoriaService {

    private final CategoriaRepo categoriaRepo;

    @Autowired
    public CategoriaService(CategoriaRepo categoriaRepo) {
        this.categoriaRepo = categoriaRepo;
    }


    public List<Categoria> findAllCategorias() {
        return categoriaRepo.findAll();
    }

    public Categoria findCategoriaById(Long id) {
        return categoriaRepo.findCategoriaById(id).orElseThrow(()-> new IllegalArgumentException("Categoria not found"));
    }

    public Categoria updateCategoria(Categoria categoria, Long id) {
        if (categoriaRepo.findCategoriaById(id).isPresent()){
            categoria.setId(id);
            return categoriaRepo.save(categoria);
        }   else{return null;}
    }

    public void deleteCategoria(Long id) {
        categoriaRepo.deleteById(id);
    }

    public Categoria addCategoria(Categoria categoria){
        return categoriaRepo.save(categoria);
    }
}
