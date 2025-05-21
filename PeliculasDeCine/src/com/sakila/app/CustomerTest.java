package com.sakila.app;

import com.sakila.models.Customer;
import com.sakila.bll.CustomerManager;

import java.sql.Timestamp;

public class CustomerTest {
    public static void main(String[] args) {
        Timestamp ahora = new Timestamp(System.currentTimeMillis());

        // Crear un cliente
        Customer cliente = new Customer(
                1, "Juan", "Pérez", "juan@email.com",
                1, 5, true, ahora, ahora
        );

        // Instanciar el manejador
        CustomerManager gestor = new CustomerManager();
        gestor.agregarCliente(cliente);

        // Buscar por ID
        Customer encontrado = gestor.buscarPorId(1);
        if (encontrado != null) {
            System.out.println("✅ Cliente encontrado:");
            System.out.println("ID: " + encontrado.getId());
            System.out.println("Nombre: " + encontrado.getNombre());
            System.out.println("Apellido: " + encontrado.getApellido());
            System.out.println("Dirección ID: " + encontrado.getIdDireccion());
            System.out.println("Activo: " + (encontrado.isActivo() ? "Sí" : "No"));
        } else {
            System.out.println("❌ Cliente no encontrado");
        }

        // Listar todos
        System.out.println("\n--- Todos los clientes ---");
        for (Customer c : gestor.listarClientes()) {
            System.out.println(c);
        }
    }
}
