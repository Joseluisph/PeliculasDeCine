package com.sakila.models;

import java.time.LocalDateTime;

/**
 * Representa un empleado (staff) del sistema Sakila.
 */
public class Staff {

    /** ID único del empleado. */
    private int id;

    /** Nombre del empleado. */
    private String nombre;

    /** Apellido del empleado. */
    private String apellido;

    /** ID de la dirección asociada. */
    private int idDireccion;

    /** ID de la tienda donde trabaja. */
    private int idTienda;

    /** Estado de actividad del empleado (activo o no). */
    private boolean activo;

    /** Nombre de usuario del sistema. */
    private String usuario;

    /** Fecha de la última actualización. */
    private LocalDateTime ultimaActualizacion;

    /**
     * Constructor completo de la clase Staff.
     *
     * @param id ID del empleado
     * @param nombre Nombre del empleado
     * @param apellido Apellido del empleado
     * @param idDireccion ID de la dirección
     * @param idTienda ID de la tienda
     * @param activo Si el empleado está activo
     * @param usuario Nombre de usuario
     * @param ultimaActualizacion Fecha de última modificación
     */
    public Staff(int id, String nombre, String apellido, int idDireccion, int idTienda, boolean activo, String usuario, LocalDateTime ultimaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idDireccion = idDireccion;
        this.idTienda = idTienda;
        this.activo = activo;
        this.usuario = usuario;
        this.ultimaActualizacion = ultimaActualizacion;
    }

    // Getters y Setters

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

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    @Override
    public String toString() {
        return "Staff [ID=" + id + ", Nombre=" + nombre + ", Apellido=" + apellido +
                ", Tienda=" + idTienda + ", Activo=" + activo + ", Usuario=" + usuario +
                ", Actualización=" + ultimaActualizacion + "]";
    }
}
