package com.sakila.app;

import com.sakila.models.Payment;
import com.sakila.models.Renta;
import com.sakila.repository.PaymentRepository;
import com.sakila.repository.RentaRepository;
import com.sakila.reports.PaymentReportSQL;
import com.sakila.export.PaymentExporter;
import com.sakila.export.PaymentJsonExporter;
import com.sakila.export.RentaExporter;
import com.sakila.export.RentaJsonExporter;
import com.sakila.export.PaymentReportExporter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que contiene el menú de operaciones JDBC sobre la base de datos Sakila.
 * Permite realizar operaciones CRUD sobre rentas y pagos, así como exportaciones de datos.
 * Este archivo forma parte del proyecto de simulación ORM con JDBC.
 */
public class MainMenuJDBC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentaRepository rentaRepo = new RentaRepository();
        PaymentRepository paymentRepo = new PaymentRepository();

        int opcion;

        do {
            System.out.println("\n--- MENÚ DE GESTIÓN (JDBC - Base de Datos) ---");
            System.out.println("1. Crear nueva renta");
            System.out.println("2. Buscar renta por ID");
            System.out.println("3. Listar todas las rentas");
            System.out.println("4. Actualizar renta");
            System.out.println("5. Eliminar renta");
            System.out.println("6. Ver pagos asociados a una renta");
            System.out.println("7. Registrar nuevo pago");
            System.out.println("8. Listar todos los pagos");
            System.out.println("9. Exportar pagos a CSV");
            System.out.println("10. Exportar pagos a JSON");
            System.out.println("11. Exportar rentas a CSV");
            System.out.println("12. Exportar rentas a JSON");
            System.out.println("13. Ver total de pagos por cliente");
            System.out.println("14. Exportar total de pagos por cliente a CSV");
            System.out.println("15. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID del inventario: ");
                    int invId = scanner.nextInt();
                    System.out.print("ID del cliente: ");
                    int clienteId = scanner.nextInt();
                    System.out.print("ID del empleado: ");
                    int empleadoId = scanner.nextInt();

                    Renta nuevaRenta = new Renta(0, new Timestamp(System.currentTimeMillis()), invId, clienteId, null, empleadoId);
                    boolean insertada = rentaRepo.post(nuevaRenta);
                    System.out.println(insertada ? "✅ Renta registrada." : "❌ Error al registrar la renta.");
                    break;

                case 2:
                    System.out.print("Ingrese el ID de la renta: ");
                    int idBuscar = scanner.nextInt();
                    Renta rentaEncontrada = rentaRepo.get(idBuscar);
                    System.out.println(rentaEncontrada != null ? rentaEncontrada : "❌ No se encontró la renta.");
                    break;

                case 3:
                    List<Renta> rentas = rentaRepo.get();
                    rentas.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("ID de la renta a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    Renta rentaActualizar = rentaRepo.get(idActualizar);
                    if (rentaActualizar == null) {
                        System.out.println("❌ No existe esa renta.");
                        break;
                    }
                    System.out.print("Nuevo ID de inventario: ");
                    rentaActualizar.setIdInventario(scanner.nextInt());
                    System.out.print("Nuevo ID de cliente: ");
                    rentaActualizar.setIdCliente(scanner.nextInt());
                    System.out.print("Nuevo ID de empleado: ");
                    rentaActualizar.setIdEmpleado(scanner.nextInt());
                    rentaActualizar.setFechaRenta(new Timestamp(System.currentTimeMillis()));

                    boolean actualizada = rentaRepo.put(rentaActualizar);
                    System.out.println(actualizada ? "✅ Renta actualizada." : "❌ Error al actualizar la renta.");
                    break;

                case 5:
                    System.out.print("ID de renta a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    boolean eliminada = rentaRepo.delete(idEliminar);
                    System.out.println(eliminada ? "✅ Renta eliminada." : "❌ Error al eliminar.");
                    break;

                case 6:
                    System.out.print("ID de la renta para ver pagos: ");
                    int idRentaPagos = scanner.nextInt();
                    List<Payment> pagosRenta = paymentRepo.getByRentalId(idRentaPagos);
                    pagosRenta.forEach(System.out::println);
                    break;

                case 7:
                    System.out.print("ID del cliente: ");
                    int clientePago = scanner.nextInt();
                    System.out.print("ID del empleado: ");
                    int empleadoPago = scanner.nextInt();
                    System.out.print("ID de la renta: ");
                    int rentaPago = scanner.nextInt();
                    System.out.print("Monto del pago: ");
                    BigDecimal monto = scanner.nextBigDecimal();

                    Payment nuevoPago = new Payment(0, clientePago, empleadoPago, rentaPago, monto, new Timestamp(System.currentTimeMillis()));
                    boolean pagoExitoso = paymentRepo.post(nuevoPago);
                    System.out.println(pagoExitoso ? "✅ Pago registrado." : "❌ Error al registrar el pago.");
                    break;

                case 8:
                    List<Payment> todosLosPagos = paymentRepo.get();
                    todosLosPagos.forEach(System.out::println);
                    break;

                case 9:
                    System.out.print("Nombre del archivo CSV: ");
                    String archivoPagosCsv = scanner.next();
                    PaymentExporter.exportToCSV(paymentRepo.get(), archivoPagosCsv);
                    break;

                case 10:
                    System.out.print("Nombre del archivo JSON: ");
                    String archivoPagosJson = scanner.next();
                    PaymentJsonExporter.exportToJson(paymentRepo.get(), archivoPagosJson);
                    break;

                case 11:
                    System.out.print("Nombre del archivo CSV: ");
                    String archivoRentasCsv = scanner.next();
                    RentaExporter.exportToCSV(rentaRepo.get(), archivoRentasCsv);
                    break;

                case 12:
                    System.out.print("Nombre del archivo JSON: ");
                    String archivoRentasJson = scanner.next();
                    RentaJsonExporter.exportToJson(rentaRepo.get(), archivoRentasJson);
                    break;

                case 13:
                    PaymentReportSQL.mostrarTotalPorCliente();
                    break;

                case 14:
                    System.out.print("Nombre del archivo CSV: ");
                    String archivoReporte = scanner.next();
                    PaymentReportExporter.exportarDesdeBD(archivoReporte);
                    break;

                case 15:
                    System.out.println("👋 Cerrando el sistema...");
                    break;

                default:
                    System.out.println("❗ Opción inválida.");
            }

        } while (opcion != 15);
    }
}
