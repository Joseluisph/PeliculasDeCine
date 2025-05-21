package com.sakila.export;

import com.sakila.db.ConexionDB;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;

public class PaymentReportExporter {
    public static void exportarDesdeBD(String archivoRuta) {
        String sql = """
            SELECT customer_id, SUM(amount) AS total_pagado
            FROM payment
            GROUP BY customer_id
            ORDER BY customer_id;
        """;

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();
             FileWriter writer = new FileWriter(archivoRuta)) {

            writer.append("customer_id,total_pagado\n");
            while (rs.next()) {
                int clienteId = rs.getInt("customer_id");
                BigDecimal total = rs.getBigDecimal("total_pagado");
                writer.append(clienteId + "," + total.toPlainString() + "\n");
            }
            writer.flush();
            System.out.println("✅ Reporte exportado correctamente a " + archivoRuta);

        } catch (SQLException | IOException e) {
            System.out.println("❌ Error al exportar reporte desde BD: " + e.getMessage());
        }
    }
}
