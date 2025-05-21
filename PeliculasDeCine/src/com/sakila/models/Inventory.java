package com.sakila.models;

import java.sql.Timestamp;

public class Inventory {
    private int id;              // inventory_id
    private int idPelicula;      // film_id
    private int idTienda;        // store_id
    private Timestamp ultimaActualizacion; // last_update

    public Inventory(int id, int idPelicula, int idTienda, Timestamp ultimaActualizacion) {
        this.id = id;
        this.idPelicula = idPelicula;
        this.idTienda = idTienda;
        this.ultimaActualizacion = ultimaActualizacion;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public Timestamp getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public void setUltimaActualizacion(Timestamp ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", idPelicula=" + idPelicula +
                ", idTienda=" + idTienda +
                ", ultimaActualizacion=" + ultimaActualizacion +
                '}';
    }
}
