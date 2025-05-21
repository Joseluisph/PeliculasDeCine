package com.sakila.models;

import java.sql.Timestamp;

public class Customer {
    private int id;              // customer_id
    private String nombre;       // first_name
    private String apellido;     // last_name
    private String email;
    private int idTienda;        // store_id
    private int idDireccion;     // address_id
    private boolean activo;
    private Timestamp fechaCreacion;
    private Timestamp ultimaActualizacion;

    // Constructor completo
    public Customer(int id, String nombre, String apellido, String email, int idTienda, int idDireccion, boolean activo, Timestamp fechaCreacion, Timestamp ultimaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.idTienda = idTienda;
        this.idDireccion = idDireccion;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.ultimaActualizacion = ultimaActualizacion;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public boolean isActivo() {
        return activo;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public Timestamp getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setUltimaActualizacion(Timestamp ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", idTienda=" + idTienda +
                ", idDireccion=" + idDireccion +
                ", activo=" + activo +
                ", fechaCreacion=" + fechaCreacion +
                ", ultimaActualizacion=" + ultimaActualizacion +
                '}';
    }
}
