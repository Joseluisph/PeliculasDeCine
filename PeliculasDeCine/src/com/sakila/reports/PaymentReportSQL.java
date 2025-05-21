package com.sakila.reports;

import com.sakila.db.ConexionDB;
import java.sql.*;

public class PaymentReportSQL {
    public static void mostrarTotalPorCliente() {
        String sql = """
            SELECT customer_id, SUM(amount) AS total_pagado
            FROM payment
            GROUP BY customer_id
            ORDER BY customer_id;
        """;

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("--- TOTAL PAGADO POR CLIENTE ---");
            while (rs.next()) {
                int clienteId = rs.getInt("customer_id");
                String total = rs.getBigDecimal("total_pagado").toPlainString();
                System.out.printf("Cliente ID: %d - Total: $%s%n", clienteId, total);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al generar reporte SQL: " + e.getMessage());
        }
    }
}
