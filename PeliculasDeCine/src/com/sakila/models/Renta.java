package com.sakila.models;

import java.sql.Timestamp;

/**
 * Representa una renta de una película realizada por un cliente en el sistema Sakila.
 */
public class Renta {

    /** ID único de la renta. */
    private int id;

    /** Fecha y hora en que se realizó la renta. */
    private Timestamp fechaRenta;

    /** ID del inventario (película específica) rentado. */
    private int idInventario;

    /** ID del cliente que realiza la renta. */
    private int idCliente;

    /** Fecha en que la película fue devuelta. */
    private Timestamp fechaDevolucion;

    /** ID del empleado que gestionó la renta. */
    private int idEmpleado;

    /**
     * Constructor completo de la clase Renta.
     *
     * @param id ID de la renta
     * @param fechaRenta Fecha de inicio de la renta
     * @param idInventario ID del inventario rentado
     * @param idCliente ID del cliente
     * @param fechaDevolucion Fecha de devolución
     * @param idEmpleado ID del empleado que gestionó la renta
     */
    public Renta(int id, Timestamp fechaRenta, int idInventario, int idCliente, Timestamp fechaDevolucion, int idEmpleado) {
        this.id = id;
        this.fechaRenta = fechaRenta;
        this.idInventario = idInventario;
        this.idCliente = idCliente;
        this.fechaDevolucion = fechaDevolucion;
        this.idEmpleado = idEmpleado;
    }

    /** @return ID de la renta */
    public int getId() {
        return id;
    }

    /** @param id ID de la renta */
    public void setId(int id) {
        this.id = id;
    }

    /** @return Fecha de la renta */
    public Timestamp getFechaRenta() {
        return fechaRenta;
    }

    /** @param fechaRenta Fecha de la renta */
    public void setFechaRenta(Timestamp fechaRenta) {
        this.fechaRenta = fechaRenta;
    }

    /** @return ID del inventario rentado */
    public int getIdInventario() {
        return idInventario;
    }

    /** @param idInventario ID del inventario */
    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    /** @return ID del cliente */
    public int getIdCliente() {
        return idCliente;
    }

    /** @param idCliente ID del cliente */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /** @return Fecha de devolución */
    public Timestamp getFechaDevolucion() {
        return fechaDevolucion;
    }

    /** @param fechaDevolucion Fecha de devolución */
    public void setFechaDevolucion(Timestamp fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /** @return ID del empleado */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /** @param idEmpleado ID del empleado */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "Renta [ID=" + id + ", Fecha=" + fechaRenta + ", Inventario=" + idInventario +
                ", Cliente=" + idCliente + ", Devolución=" + fechaDevolucion + ", Empleado=" + idEmpleado + "]";
    }
}
