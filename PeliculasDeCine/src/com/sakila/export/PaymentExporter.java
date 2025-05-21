package com.sakila.export;

import com.sakila.models.Payment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Exporta pagos a un archivo CSV.
 */
public class PaymentExporter {

    public static void exportToCSV(List<Payment> payments, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.append("payment_id,customer_id,staff_id,rental_id,amount,payment_date\n");

            for (Payment p : payments) {
                writer.append(String.valueOf(p.getPaymentId())).append(",");
                writer.append(String.valueOf(p.getCustomerId())).append(",");
                writer.append(String.valueOf(p.getStaffId())).append(",");
                writer.append(String.valueOf(p.getRentalId())).append(",");
                writer.append(p.getAmount().toString()).append(",");
                writer.append(p.getPaymentDate().toString()).append("\n");
            }

            writer.flush();
            System.out.println("✅ Pagos exportados correctamente a " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error al exportar CSV: " + e.getMessage());
        }
    }
}
