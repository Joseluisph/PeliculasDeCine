package com.sakila.models;

import java.time.LocalDateTime;

/**
 * Representa un actor registrado en el sistema Sakila.
 */
public class Actor {

    /** ID único del actor. */
    private int id;

    /** Nombre del actor. */
    private String nombre;

    /** Apellido del actor. */
    private String apellido;

    /** Fecha y hora de la última actualización del registro. */
    private LocalDateTime ultimaActualizacion;

    /**
     * Constructor completo de la clase Actor.
     *
     * @param id ID del actor
     * @param nombre Nombre del actor
     * @param apellido Apellido del actor
     * @param ultimaActualizacion Fecha de última modificación
     */
    public Actor(int id, String nombre, String apellido, LocalDateTime ultimaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    @Override
    public String toString() {
        return "Actor [ID=" + id + ", Nombre=" + nombre + ", Apellido=" + apellido +
                ", Actualizado=" + ultimaActualizacion + "]";
    }
}
