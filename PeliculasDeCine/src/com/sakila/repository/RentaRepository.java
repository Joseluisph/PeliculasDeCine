package com.sakila.repository;

import com.sakila.db.ConexionDB;
import com.sakila.interfaces.iDatapost;
import com.sakila.models.Renta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio JDBC para la entidad Renta.
 * Permite operaciones CRUD sobre la tabla renta.
 */
public class RentaRepository implements iDatapost<Renta> {

    @Override
    public boolean post(Renta renta) {
        String sql = "INSERT INTO renta (fecha_renta, id_inventario, id_cliente, fecha_devolucion, id_empleado, ultima_actualizacion) " +
                "VALUES (?, ?, ?, ?, ?, NOW())";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, renta.getFechaRenta());
            stmt.setInt(2, renta.getIdInventario());
            stmt.setInt(3, renta.getIdCliente());
            stmt.setTimestamp(4, renta.getFechaDevolucion());
            stmt.setInt(5, renta.getIdEmpleado());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error insertando renta: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Renta get(int id) {
        String sql = "SELECT * FROM renta WHERE id = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapear(rs);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error buscando renta: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Renta> get() {
        List<Renta> lista = new ArrayList<>();
        String sql = "SELECT * FROM renta";

        try (Connection conn = ConexionDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapear(rs));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error listando rentas: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public boolean put(Renta renta) {
        String sql = "UPDATE renta SET fecha_renta = ?, id_inventario = ?, id_cliente = ?, fecha_devolucion = ?, id_empleado = ?, ultima_actualizacion = NOW() " +
                "WHERE id = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, renta.getFechaRenta());
            stmt.setInt(2, renta.getIdInventario());
            stmt.setInt(3, renta.getIdCliente());
            stmt.setTimestamp(4, renta.getFechaDevolucion());
            stmt.setInt(5, renta.getIdEmpleado());
            stmt.setInt(6, renta.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error actualizando renta: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM renta WHERE id = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error eliminando renta: " + e.getMessage());
            return false;
        }
    }

    /**
     * Convierte un ResultSet en un objeto Renta.
     *
     * @param rs ResultSet
     * @return Renta
     * @throws SQLException error al leer
     */
    private Renta mapear(ResultSet rs) throws SQLException {
        return new Renta(
                rs.getInt("id"),
                rs.getTimestamp("fecha_renta"),
                rs.getInt("id_inventario"),
                rs.getInt("id_cliente"),
                rs.getTimestamp("fecha_devolucion"),
                rs.getInt("id_empleado")
        );
    }
}
