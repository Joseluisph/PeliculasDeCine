package com.sakila.export;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sakila.models.Payment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PaymentJsonExporter {

    public static void exportToJson(List<Payment> payments, String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(payments, writer);
            System.out.println("✅ Pagos exportados a JSON correctamente en: " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error al exportar JSON: " + e.getMessage());
        }
    }
}
