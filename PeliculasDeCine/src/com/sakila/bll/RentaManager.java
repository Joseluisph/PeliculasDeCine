package com.sakila.bll;

import com.sakila.models.Renta;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RentaManager {
    private final List<Renta> rentas;

    public RentaManager() {
        this.rentas = new ArrayList<>();
    }

    // Agregar una nueva renta
    public void agregarRenta(Renta renta) {
        rentas.add(renta);
    }

    // Buscar una renta por ID
    public Renta buscarPorId(int id) {
        for (Renta r : rentas) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    // Actualizar una renta existente
    public boolean actualizarRenta(int id, int nuevoInventario, int nuevoCliente, int nuevoEmpleado, Timestamp nuevaFechaDevolucion) {
        Renta renta = buscarPorId(id);
        if (renta != null) {
            renta.setIdInventario(nuevoInventario);
            renta.setIdCliente(nuevoCliente);
            renta.setIdEmpleado(nuevoEmpleado);
            renta.setFechaDevolucion(nuevaFechaDevolucion);
            renta.setFechaRenta(new Timestamp(System.currentTimeMillis()));
            return true;
        }
        return false;
    }

    // Eliminar una renta
    public boolean eliminarRenta(int id) {
        Renta renta = buscarPorId(id);
        if (renta != null) {
            return rentas.remove(renta);
        }
        return false;
    }

    // Listar todas las rentas
    public List<Renta> listarRentas() {
        return rentas;
    }

    // Crear una renta rápida (para pruebas)
    public Renta crearRentaDemo(int id, int idInventario, int idCliente, int idEmpleado) {
        Timestamp ahora = new Timestamp(System.currentTimeMillis());
        return new Renta(id, ahora, idInventario, idCliente, null, idEmpleado);
    }
}
