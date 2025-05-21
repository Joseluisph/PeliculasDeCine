package com.sakila.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase de utilidad para establecer conexión JDBC con la base de datos MySQL.
 */
public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/sakila";
    private static final String USUARIO = "root";
    private static final String CLAVE = "Foquis2424.."; // cambia si usas contraseña

    /**
     * Establece y retorna una conexión a la base de datos.
     *
     * @return objeto Connection
     * @throws SQLException si ocurre un error de conexión
     */
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}
