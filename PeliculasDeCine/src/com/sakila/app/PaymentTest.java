package com.sakila.app;

import com.sakila.bll.PaymentManager;
import com.sakila.models.Payment;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PaymentTest {
    public static void main(String[] args) {
        PaymentManager manager = new PaymentManager();

        Payment pago1 = new Payment(1, 101, 201, 301, new BigDecimal("250.00"), new Timestamp(System.currentTimeMillis()));
        Payment pago2 = new Payment(2, 102, 202, 302, new BigDecimal("300.00"), new Timestamp(System.currentTimeMillis()));

        manager.post(pago1);
        manager.post(pago2);

        System.out.println("📄 Pagos registrados:");
        manager.get().forEach(System.out::println);

        System.out.println("🔍 Pago con ID 1: " + manager.get(1));

        pago1.setAmount(new BigDecimal("275.00"));
        manager.put(pago1);

        System.out.println("📝 Actualizado:");
        System.out.println(manager.get(1));

        manager.delete(2);
        System.out.println("❌ Después de eliminar ID 2:");
        manager.get().forEach(System.out::println);
    }
}
