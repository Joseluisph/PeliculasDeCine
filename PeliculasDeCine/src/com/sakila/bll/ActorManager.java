package com.sakila.bll;

import com.sakila.db.ConexionDB;
import com.sakila.models.Actor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestor para operaciones relacionadas con actores.
 */
public class ActorManager {

    /**
     * Obtiene todos los actores registrados.
     *
     * @return Lista de actores
     */
    public List<Actor> obtenerTodos() {
        List<Actor> lista = new ArrayList<>();
        String sql = "SELECT * FROM actor";

        try (Connection conn = ConexionDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapear(rs));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al obtener actores: " + e.getMessage());
        }

        return lista;
    }

    /**
     * Busca un actor por su ID.
     *
     * @param id ID del actor
     * @return Objeto Actor si se encuentra, null si no
     */
    public Actor buscarPorId(int id) {
        String sql = "SELECT * FROM actor WHERE actor_id = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapear(rs);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al buscar actor: " + e.getMessage());
        }

        return null;
    }

    /**
     * Mapea un ResultSet en un objeto Actor.
     *
     * @param rs ResultSet con datos del actor
     * @return Objeto Actor
     * @throws SQLException Si ocurre un error de lectura
     */
    private Actor mapear(ResultSet rs) throws SQLException {
        return new Actor(
                rs.getInt("actor_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getObject("last_update", java.time.LocalDateTime.class)  // ✅ aquí está la conversión correcta
        );
    }

}
