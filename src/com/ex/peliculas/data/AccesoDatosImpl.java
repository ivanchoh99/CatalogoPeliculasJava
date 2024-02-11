package com.ex.peliculas.data;

import com.ex.peliculas.domain.Pelicula;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.ex.peliculas.constant.Constantes.ruta;

public class AccesoDatosImpl implements IAccesoDatos {

    private String extensionArchivo(String nombreArchivo) {
        return nombreArchivo.concat(".txt");
    }

    @Override
    public boolean existe(String nombreArchivo) {
        File file = new File(ruta.concat(this.extensionArchivo(nombreArchivo)));
        if (!file.exists()) {
            System.out.println("--El catalogo '" + nombreArchivo + "' no existe--");
        }
        return file.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) {

        List<Pelicula> peliculas = new ArrayList<>();

        if (!this.existe(nombreArchivo)) return null;

        try {
            String archivo = extensionArchivo(nombreArchivo);
            BufferedReader reader = new BufferedReader(new FileReader(ruta.concat(archivo)));
            for (String linea : reader.lines().toList()) {
                peliculas.add(new Pelicula(linea));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, Boolean anexar) {

        this.existe(nombreArchivo);

        File file = new File(ruta + this.extensionArchivo(nombreArchivo));
        try {
            FileWriter escritor = new FileWriter(file, true);
            escritor.append(pelicula.getNombre().concat("\n"));
            escritor.close();
            System.out.println("--Se agrego la pelicula '" + pelicula.getNombre() + "' al catalogo de peliculas--");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public String buscarPelicula(String nombreArchivo, String buscar) {

        List<Pelicula> peliculas;
        Pelicula peli = null;

        peliculas = this.listar(nombreArchivo);
        int indice = 1;
        for (Pelicula p : peliculas) {
            if (p.getNombre().equals(buscar)) {
                peli = p;
                break;
            }
            indice++;
        }

        if (peli == null) {
            System.out.println("--La pelicula '" + buscar + "' no existe--");
            return null;
        }

        return "la pelicula '" + buscar + "' esta en la posición: " + indice;
    }

    @Override
    public void crear(String nombreArchivo) {

        if (this.existe(nombreArchivo)) {
            System.out.println("--El catalogo '" + nombreArchivo + "' YA existe--");
        } else {

            try {
                File file = new File(ruta.concat(this.extensionArchivo(nombreArchivo)));

                if (!file.createNewFile()) {
                    System.out.println("--Error al crear el catalogo '" + nombreArchivo + "--");
                }

                System.out.println("--El catalogo '" + nombreArchivo + "' se creo correctamente--");

            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }

    }

    @Override
    public void borrar(String nombreArchivo) {

        this.existe(nombreArchivo);

        File file = new File(ruta.concat(this.extensionArchivo(nombreArchivo)));
        if (file.delete()) {
            System.out.println("--Catalogo '" + nombreArchivo + "' eliminado correctamente--");
        }

    }
}
