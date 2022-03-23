package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Libro implements Serializable {


    @Getter
    @Setter
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @NotNull
    private String titulo;

    @Getter
    @Setter
    @NotNull
    private int edicion;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_Autor")
    @Nullable
    private Autor autor;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_Categoria")
    @NotNull
    private Categoria categoria;
}
