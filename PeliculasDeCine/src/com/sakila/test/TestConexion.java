package com.sakila.test;

import com.sakila.db.ConexionDB;

import java.sql.Connection;

public class TestConexion {
    public static void main(String[] args) {
        try (Connection conn = ConexionDB.conectar()) {
            if (conn != null) {
                System.out.println("✅ Conexión exitosa a la base de datos Sakila.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error al conectar: " + e.getMessage());
        }
    }
}
