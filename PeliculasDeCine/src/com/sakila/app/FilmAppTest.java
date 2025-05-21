package com.sakila.app;

import com.sakila.bll.FilmManager;
import com.sakila.models.Film;

import java.util.List;

/**
 * Clase de prueba para consultar y mostrar todas las películas registradas en la base de datos.
 */
public class FilmAppTest {

    public static void main(String[] args) {
        FilmManager gestorPeliculas = new FilmManager();

        System.out.println("🎬 Listando todas las películas...\n");

        List<Film> peliculas = gestorPeliculas.obtenerTodas();

        if (peliculas.isEmpty()) {
            System.out.println("❌ No se encontraron películas en la base de datos.");
        } else {
            for (Film f : peliculas) {
                System.out.println("ID: " + f.getId() +
                        " | Título: " + f.getTitulo() +
                        " | Año: " + f.getAnioEstreno());
            }
        }
    }
}
