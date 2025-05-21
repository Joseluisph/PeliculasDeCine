package com.sakila.repository;

import com.sakila.db.ConexionDB;
import com.sakila.interfaces.iDatapost;
import com.sakila.models.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio de datos para gestionar operaciones CRUD sobre pagos (Payment).
 * Implementa la interfaz iDatapost para cumplir con la estructura estándar del proyecto.
 */
public class PaymentRepository implements iDatapost<Payment> {

    /**
     * Inserta un nuevo registro de pago en la base de datos.
     *
     * @param payment Objeto Payment a insertar
     * @return true si se insertó correctamente, false si ocurrió un error
     */
    @Override
    public boolean post(Payment payment) {
        String sql = "INSERT INTO pago (customer_id, staff_id, rental_id, amount, payment_date, last_update) " +
                "VALUES (?, ?, ?, ?, ?, NOW())";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, payment.getCustomerId());
            stmt.setInt(2, payment.getStaffId());
            stmt.setInt(3, payment.getRentalId());
            stmt.setBigDecimal(4, payment.getAmount());
            stmt.setTimestamp(5, payment.getPaymentDate());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar pago: " + e.getMessage());
            return false;
        }
    }

    /**
     * Obtiene todos los pagos registrados en la base de datos.
     *
     * @return Lista de objetos Payment
     */
    @Override
    public List<Payment> get() {
        List<Payment> pagos = new ArrayList<>();
        String sql = "SELECT * FROM pago";

        try (Connection conn = ConexionDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                pagos.add(mapear(rs));
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al listar pagos: " + e.getMessage());
        }

        return pagos;
    }

    /**
     * Busca un pago por su ID (no implementado por simplicidad en este proyecto).
     */
    @Override
    public Payment get(int id) {
        return null;
    }

    /**
     * Actualiza un pago (no implementado en esta versión).
     */
    @Override
    public boolean put(Payment entity) {
        return false;
    }

    /**
     * Elimina un pago (no implementado en esta versión).
     */
    @Override
    public boolean delete(int id) {
        return false;
    }

    /**
     * Obtiene los pagos asociados a una renta específica.
     *
     * @param rentalId ID de la renta
     * @return Lista de pagos asociados
     */
    public List<Payment> getByRentalId(int rentalId) {
        List<Payment> lista = new ArrayList<>();
        String sql = "SELECT * FROM pago WHERE rental_id = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, rentalId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(mapear(rs));
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al consultar pagos por renta: " + e.getMessage());
        }

        return lista;
    }

    /**
     * Mapea los datos del ResultSet a un objeto Payment.
     *
     * @param rs ResultSet con los datos
     * @return Objeto Payment mapeado
     * @throws SQLException si ocurre error al leer columnas
     */
    private Payment mapear(ResultSet rs) throws SQLException {
        return new Payment(
                rs.getInt("payment_id"),
                rs.getInt("customer_id"),
                rs.getInt("staff_id"),
                rs.getInt("rental_id"),
                rs.getBigDecimal("amount"),
                rs.getTimestamp("payment_date")
        );
    }
}
