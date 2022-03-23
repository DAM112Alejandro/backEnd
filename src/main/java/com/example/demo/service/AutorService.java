package com.example.demo.service;


import com.example.demo.model.Autor;


import com.example.demo.repo.AutorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class AutorService {
    private final AutorRepo autorRepo;

    @Autowired
    public AutorService(AutorRepo autorrepo) {
        this.autorRepo = autorrepo;
    }

    public List<Autor> findAllAutors() {
        return autorRepo.findAll();
    }

    public Autor findAutorByDni(String dni) {
        return autorRepo.getBydni(dni).orElseThrow(()->new IllegalArgumentException("autor not found"));
    }




    public Autor addAutor(Autor autor) {
    return autorRepo.save(autor);
    }

    public void deleteAutor(String dni) {
        autorRepo.deleteAutorByDni(dni);
    }

    public Autor updateAutor(Autor autor, String dni) { if (autorRepo.getBydni(dni).isPresent()) {
        return autorRepo.save(autor);
    } else {
        throw  new IllegalArgumentException("Autor not found");
    }
    }
}


