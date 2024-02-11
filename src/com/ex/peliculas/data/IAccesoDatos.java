package com.ex.peliculas.data;

import com.ex.peliculas.domain.Pelicula;

import java.io.FileNotFoundException;
import java.util.List;

public interface IAccesoDatos {

    boolean existe(String nombre);

    List<Pelicula> listar(String nombre);

    void escribir(Pelicula pelicula, String nombreArchivo, Boolean anexar);

    String buscarPelicula(String nombreArchivo, String buscar);

    void crear(String nombreArchivo);

    void borrar(String nombreArchivo);
}
