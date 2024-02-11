package com.ex.peliculas.logic;

import java.io.FileNotFoundException;

public interface ICatalogoPeliculas {

    boolean existe(String nombreArchivo);
    void agregarPelicula(String nombrePelicula, String nombreArchivo) ;

    void listarPeliculas(String nombreArchivo) ;

    void buscarPelicula(String nombreArchivo, String buscar) ;

    void iniciarArchivo(String nombreArchivo) ;
}
