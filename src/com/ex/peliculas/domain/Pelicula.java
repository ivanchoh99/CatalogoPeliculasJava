package com.ex.peliculas.domain;

//TODO Se puede simplificar la clase usando loombok
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@Data <-- Getter, Setter, toString, Constructor con todos los argumentos
//@NoArgsConstructor<-- Constructor vacio
//TODO --------------------------------------------
public class Pelicula {

    private String nombre;

    public Pelicula() {
    }

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
