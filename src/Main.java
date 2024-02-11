import com.ex.peliculas.logic.CatalogoPeliculasImpl;
import com.ex.peliculas.logic.ICatalogoPeliculas;

import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {

        ICatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();
        Scanner scanner = new Scanner(System.in);
        boolean salida = false;

        while (!salida) {

            System.out.println(
                    """
                            __________________________________
                            |        Elige una opcion        |
                            |________________________________|
                            |1. Iniciar Catalogo de peliculas|
                            |2. Agregar Pelicula             |
                            |3. Listar Peliculas             |
                            |4. Buscar Pelicula              |
                            |0. Salir                        |
                            |________________________________|
                            """);

            System.out.println("--Escoja una opcion:--");
            int option = scanner.nextInt();
            String inputNombre = "";
            String inputCatalogo = "";
            scanner.nextLine();


            switch (option) {
                case 1:
                    System.out.println("Introduce el nombre del catalogo: ");
                    inputCatalogo = scanner.nextLine();
                    catalogoPeliculas.iniciarArchivo(inputCatalogo);
                    break;
                case 2:

                    while (inputNombre.isEmpty()) {
                        System.out.println("Introduce el nombre de la pelicula:");
                        inputNombre = scanner.nextLine();
                    }
                    while (inputCatalogo.isEmpty()) {
                        System.out.println("Introduce el nombre del catalogo:");
                        inputCatalogo = scanner.nextLine();
                    }
                    catalogoPeliculas.agregarPelicula(inputNombre, inputCatalogo);
                    break;
                case 3:
                    System.out.println("Introduce el nombre del catalogo que desea ver: ");
                    inputCatalogo = scanner.nextLine();
                    catalogoPeliculas.listarPeliculas(inputCatalogo);
                    break;
                case 4:
                    while (inputCatalogo.isEmpty()) {
                        System.out.println("Introduce el nombre del catalogo: ");
                        inputCatalogo = scanner.nextLine();
                    }
                    if (!catalogoPeliculas.existe(inputCatalogo)) break;
                    while (inputNombre.isEmpty()) {
                        System.out.println("Introduce el nombre de la pelicula: ");
                        inputNombre = scanner.nextLine();
                    }
                    catalogoPeliculas.buscarPelicula(inputCatalogo, inputNombre);
                    break;
                case 0:
                    salida = true;
                    break;
            }
        }
    }
}