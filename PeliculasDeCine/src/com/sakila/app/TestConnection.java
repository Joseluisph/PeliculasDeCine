package com.sakila.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sakila"; // Asegúrate que la BD "sakila" exista
        String user = "root";                              // Cambia esto por tu usuario
        String password = "Foquis2424..";                      // Cambia esto por tu contraseña

        try {
            // Cargar el driver MySQL (recomendado)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Intentar la conexión
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Conexión exitosa a la base de datos Sakila.");
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("❌ No se encontró el driver MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar: " + e.getMessage());
        }
    }
}
