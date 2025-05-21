package com.sakila.bll;

import com.sakila.db.ConexionDB;
import com.sakila.models.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestor para operaciones relacionadas con las películas en la base de datos.
 */
public class FilmManager {

    /**
     * Obtiene una lista de todas las películas registradas.
     *
     * @return Lista de películas
     */
    public List<Film> obtenerTodas() {
        List<Film> lista = new ArrayList<>();
        String sql = "SELECT * FROM pelicula";

        try (Connection conexion = ConexionDB.conectar();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapear(rs));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al obtener películas: " + e.getMessage());
        }

        return lista;
    }

    /**
     * Busca una película por su ID.
     *
     * @param id ID de la película
     * @return Película encontrada o null
     */
    public Film buscarPorId(int id) {
        String sql = "SELECT * FROM pelicula WHERE id = ?";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapear(rs);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al buscar película: " + e.getMessage());
        }

        return null;
    }

    /**
     * Convierte un resultado de base de datos en un objeto Film.
     *
     * @param rs ResultSet con datos de la película
     * @return Objeto Film
     * @throws SQLException si hay error al leer los datos
     */
    private Film mapear(ResultSet rs) throws SQLException {
        return new Film(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getString("descripcion"),
                rs.getInt("anio_estreno"),
                rs.getInt("id_idioma"),
                rs.getInt("duracion"),
                rs.getTimestamp("ultima_actualizacion")
        );
    }
}
