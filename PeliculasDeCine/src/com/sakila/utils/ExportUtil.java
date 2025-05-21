package com.sakila.utils;

import com.sakila.models.Customer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportUtil {

    /**
     * Exporta una lista de clientes a un archivo CSV.
     *
     * @param clientes Lista de objetos Customer
     * @param nombreArchivo Nombre del archivo de salida
     */
    public static void exportarClientesCSV(List<Customer> clientes, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Encabezados
            writer.write("ID,Nombre,Apellido,Email,ID Tienda,ID Dirección,Activo");
            writer.newLine();

            // Datos
            for (Customer c : clientes) {
                writer.write(
                        c.getId() + "," +
                                c.getNombre() + "," +
                                c.getApellido() + "," +
                                c.getEmail() + "," +
                                c.getIdTienda() + "," +
                                c.getIdDireccion() + "," +
                                (c.isActivo() ? "Sí" : "No")
                );
                writer.newLine();
            }

            System.out.println("✅ Clientes exportados exitosamente a " + nombreArchivo);

        } catch (IOException e) {
            System.out.println("❌ Error al exportar clientes: " + e.getMessage());
        }
    }
}
