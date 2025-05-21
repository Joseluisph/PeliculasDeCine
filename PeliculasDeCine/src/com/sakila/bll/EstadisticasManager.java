package com.sakila.bll;

import com.sakila.db.ConexionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * Clase para calcular estadísticas generales del sistema de rentas.
 * Utiliza consultas SQL sobre la base de datos para extraer información agregada.
 */
public class EstadisticasManager {

    /**
     * Muestra el total de rentas registradas en el sistema.
     */
    public void mostrarTotalRentas() {
        String sql = "SELECT COUNT(*) AS total FROM renta";

        try (Connection conn = ConexionDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                int total = rs.getInt("total");
                System.out.println("📊 Total de rentas registradas: " + total);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al obtener total de rentas: " + e.getMessage());
        }
    }

    /**
     * Muestra el total de pagos realizados por todos los clientes.
     */
    public void mostrarTotalPagos() {
        String sql = "SELECT SUM(amount) AS total FROM pago";

        try (Connection conn = ConexionDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                double total = rs.getDouble("total");
                System.out.println("💰 Total de pagos registrados: $" + total);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al obtener total de pagos: " + e.getMessage());
        }
    }

    /**
     * Muestra la cantidad de clientes activos.
     */
    public void mostrarClientesActivos() {
        String sql = "SELECT COUNT(*) AS activos FROM cliente WHERE activo = 1";

        try (Connection conn = ConexionDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                int activos = rs.getInt("activos");
                System.out.println("👥 Clientes activos: " + activos);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al contar clientes activos: " + e.getMessage());
        }
    }
}
