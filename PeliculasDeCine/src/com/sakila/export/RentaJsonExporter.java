package com.sakila.export;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sakila.models.Renta;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Exporta una lista de rentas al formato JSON.
 */
public class RentaJsonExporter {

    /**
     * Exporta la lista de rentas a un archivo JSON.
     *
     * @param rentas   Lista de objetos Renta.
     * @param filename Nombre del archivo de salida (ej. rentas.json).
     */
    public static void exportToJson(List<Renta> rentas, String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(rentas, writer);
            System.out.println("✅ Rentas exportadas a JSON correctamente en: " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error al exportar JSON: " + e.getMessage());
        }
    }
}
