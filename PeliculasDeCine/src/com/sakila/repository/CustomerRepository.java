package com.sakila.repository;

import com.sakila.models.Customer;
import com.sakila.db.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    public boolean insertarCliente(Customer cliente) {
        String sql = "INSERT INTO customer (store_id, first_name, last_name, email, address_id, active, create_date, last_update) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cliente.getIdTienda());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getApellido());
            stmt.setString(4, cliente.getEmail());
            stmt.setInt(5, cliente.getIdDireccion());
            stmt.setBoolean(6, cliente.isActivo());
            stmt.setTimestamp(7, cliente.getFechaCreacion());
            stmt.setTimestamp(8, cliente.getUltimaActualizacion());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error insertando cliente: " + e.getMessage());
            return false;
        }
    }

    public Customer buscarPorId(int id) {
        String sql = "SELECT * FROM customer WHERE customer_id = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapearCliente(rs);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error buscando cliente: " + e.getMessage());
        }

        return null;
    }

    public List<Customer> listarTodos() {
        List<Customer> lista = new ArrayList<>();
        String sql = "SELECT * FROM customer";

        try (Connection conn = ConexionDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapearCliente(rs));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error listando clientes: " + e.getMessage());
        }

        return lista;
    }

    public boolean actualizarCliente(Customer cliente) {
        String sql = "UPDATE customer SET first_name=?, last_name=?, email=?, store_id=?, address_id=?, active=?, last_update=? WHERE customer_id=?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getIdTienda());
            stmt.setInt(5, cliente.getIdDireccion());
            stmt.setBoolean(6, cliente.isActivo());
            stmt.setTimestamp(7, cliente.getUltimaActualizacion());
            stmt.setInt(8, cliente.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error actualizando cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarCliente(int id) {
        String sql = "DELETE FROM customer WHERE customer_id = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error eliminando cliente: " + e.getMessage());
            return false;
        }
    }

    private Customer mapearCliente(ResultSet rs) throws SQLException {
        return new Customer(
                rs.getInt("customer_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getInt("store_id"),
                rs.getInt("address_id"),
                rs.getBoolean("active"),
                rs.getTimestamp("create_date"),
                rs.getTimestamp("last_update")
        );
    }
}
