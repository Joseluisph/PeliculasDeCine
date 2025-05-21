package com.sakila.export;

import com.sakila.models.Renta;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class RentaExporter {

    /**
     * Exporta una lista de rentas a un archivo CSV.
     *
     * @param rentas Lista de objetos Renta
     * @param nombreArchivo Nombre del archivo CSV
     */
    public static void exportToCSV(List<Renta> rentas, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribir encabezado
            writer.write("ID,Fecha Renta,ID Inventario,ID Cliente,Fecha Devolución,ID Empleado");
            writer.newLine();

            // Escribir cada renta
            for (Renta r : rentas) {
                writer.write(
                        r.getId() + "," +
                                r.getFechaRenta() + "," +
                                r.getIdInventario() + "," +
                                r.getIdCliente() + "," +
                                (r.getFechaDevolucion() != null ? r.getFechaDevolucion() : "") + "," +
                                r.getIdEmpleado()
                );
                writer.newLine();
            }

            System.out.println("✅ Rentas exportadas exitosamente a " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("❌ Error al exportar rentas: " + e.getMessage());
        }
    }
}
