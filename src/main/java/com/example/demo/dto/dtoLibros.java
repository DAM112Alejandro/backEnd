package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class dtoLibros {
    @Getter
    @Setter
    private  Long id;
    @Getter
    @Setter
    private String titulo;
    @Getter
    @Setter
    private int edicion;
    @Getter
    @Setter
    private String autor;
    @Getter
    @Setter
    private String categoria;



}
