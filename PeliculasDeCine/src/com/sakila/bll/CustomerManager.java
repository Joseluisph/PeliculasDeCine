package com.sakila.bll;

import com.sakila.models.Customer;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private final List<Customer> clientes;

    public CustomerManager() {
        this.clientes = new ArrayList<>();
    }

    // Agregar un cliente
    public void agregarCliente(Customer cliente) {
        clientes.add(cliente);
    }

    // Buscar cliente por ID
    public Customer buscarPorId(int id) {
        for (Customer c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    // Actualizar cliente
    public boolean actualizarCliente(int id, String nuevoNombre, String nuevoApellido, String nuevoEmail,
                                     int nuevaTienda, int nuevaDireccion, boolean activo) {
        Customer cliente = buscarPorId(id);
        if (cliente != null) {
            cliente.setNombre(nuevoNombre);
            cliente.setApellido(nuevoApellido);
            cliente.setEmail(nuevoEmail);
            cliente.setIdTienda(nuevaTienda);
            cliente.setIdDireccion(nuevaDireccion);
            cliente.setActivo(activo);
            cliente.setUltimaActualizacion(new Timestamp(System.currentTimeMillis()));
            return true;
        }
        return false;
    }

    // Eliminar cliente por ID
    public boolean eliminarCliente(int id) {
        Customer cliente = buscarPorId(id);
        if (cliente != null) {
            return clientes.remove(cliente);
        }
        return false;
    }

    // Listar todos los clientes
    public List<Customer> listarClientes() {
        return clientes;
    }

    // Crear cliente rápido (para pruebas o menú)
    public Customer crearClienteDemo(int id, String nombre, String apellido, String email, int idTienda, int idDireccion, boolean activo) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return new Customer(id, nombre, apellido, email, idTienda, idDireccion, activo, now, now);
    }
}
