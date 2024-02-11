package com.ex.peliculas.logic;

import com.ex.peliculas.data.AccesoDatosImpl;
import com.ex.peliculas.data.IAccesoDatos;
import com.ex.peliculas.domain.Pelicula;

import java.io.FileNotFoundException;
import java.util.List;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private final IAccesoDatos accesoDatos;

    public CatalogoPeliculasImpl() {
        this.accesoDatos = new AccesoDatosImpl();
    }

    @Override
    public boolean existe(String nombreArchivo) {
        return accesoDatos.existe(nombreArchivo);
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        Pelicula peli = new Pelicula(nombrePelicula);
        accesoDatos.escribir(peli, nombreArchivo, true);
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {

        if (this.existe(nombreArchivo)) {
            List<Pelicula> peliculas = accesoDatos.listar(nombreArchivo);
            System.out.println("|--Peliculas--|");
            int index = 0;
            for (Pelicula peli : peliculas) {
                ++index;
                System.out.println("--> " + index + ". " + peli.getNombre());
            }
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        String res = accesoDatos.buscarPelicula(nombreArchivo, buscar);

        if (res != null) {
            System.out.println(res);
        }
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        accesoDatos.crear(nombreArchivo);
    }
}
