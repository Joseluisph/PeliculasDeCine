package com.sakila.bll;

import com.sakila.db.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase de lógica de negocio para gestionar devoluciones de rentas.
 * Esta clase actualiza la fecha de devolución (return_date) en una renta específica.
 */
public class ReturnManager {

    /**
     * Marca una renta como devuelta actualizando su fecha de devolución con la hora actual.
     *
     * @param idRenta ID de la renta a marcar como devuelta
     * @return true si la operación fue exitosa, false si ocurrió un error
     */
    public boolean procesarDevolucion(int idRenta) {
        String sql = "UPDATE renta SET return_date = NOW() WHERE renta_id = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idRenta);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al procesar devolución: " + e.getMessage());
            return false;
        }
    }
}
