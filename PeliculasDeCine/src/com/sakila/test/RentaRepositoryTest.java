package com.sakila.test;

import com.sakila.models.Renta;
import com.sakila.repository.RentaRepository;

import java.util.List;

/**
 * Clase de prueba para validar el funcionamiento de RentaRepository.
 * Esta prueba ejecuta la recuperación de todas las rentas desde la base de datos.
 */
public class RentaRepositoryTest {

    public static void main(String[] args) {
        RentaRepository repo = new RentaRepository();

        System.out.println("📌 Listando rentas desde la base de datos...");
        List<Renta> lista = repo.get();

        if (lista.isEmpty()) {
            System.out.println("❌ No se encontraron rentas.");
        } else {
            for (Renta renta : lista) {
                System.out.println(renta);
            }
        }
    }
}
