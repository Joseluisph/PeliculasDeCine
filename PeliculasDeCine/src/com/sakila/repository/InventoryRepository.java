package com.sakila.repository;

import com.sakila.models.Inventory;
import com.sakila.db.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryRepository {

    public boolean insertarInventory(Inventory inv) {
        String sql = "INSERT INTO inventory (film_id, store_id, last_update) VALUES (?, ?, NOW())";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, inv.getIdPelicula());
            stmt.setInt(2, inv.getIdTienda());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error insertando inventario: " + e.getMessage());
            return false;
        }
    }

    public Inventory getInventoryById(int id) {
        String sql = "SELECT * FROM inventory WHERE inventory_id = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapearInventory(rs);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error buscando inventario: " + e.getMessage());
        }

        return null;
    }

    public List<Inventory> getAllInventories() {
        List<Inventory> lista = new ArrayList<>();
        String sql = "SELECT * FROM inventory";

        try (Connection conn = ConexionDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapearInventory(rs));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error listando inventarios: " + e.getMessage());
        }

        return lista;
    }

    public boolean actualizarInventory(Inventory inv) {
        String sql = "UPDATE inventory SET film_id=?, store_id=?, last_update=NOW() WHERE inventory_id=?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, inv.getIdPelicula());
            stmt.setInt(2, inv.getIdTienda());
            stmt.setInt(3, inv.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error actualizando inventario: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarInventory(int id) {
        String sql = "DELETE FROM inventory WHERE inventory_id = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error eliminando inventario: " + e.getMessage());
            return false;
        }
    }

    private Inventory mapearInventory(ResultSet rs) throws SQLException {
        return new Inventory(
                rs.getInt("inventory_id"),
                rs.getInt("film_id"),
                rs.getInt("store_id"),
                rs.getTimestamp("last_update")
        );
    }
}
