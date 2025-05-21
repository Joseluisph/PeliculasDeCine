package com.sakila.models;

import java.sql.Timestamp;

/**
 * Representa una película registrada en el sistema Sakila.
 */
public class Film {

    /** ID único de la película. */
    private int id;

    /** Título de la película. */
    private String titulo;

    /** Descripción o sinopsis de la película. */
    private String descripcion;

    /** Año de estreno. */
    private int anioEstreno;

    /** ID del idioma original de la película. */
    private int idIdioma;

    /** Duración de la película en minutos. */
    private int duracion;

    /** Fecha de última actualización del registro. */
    private Timestamp ultimaActualizacion;

    /**
     * Constructor completo de la clase Pelicula.
     *
     * @param id ID de la película
     * @param titulo Título
     * @param descripcion Descripción
     * @param anioEstreno Año de estreno
     * @param idIdioma ID del idioma
     * @param duracion Duración en minutos
     * @param ultimaActualizacion Fecha de actualización
     */
    public Film(int id, String titulo, String descripcion, int anioEstreno, int idIdioma, int duracion, Timestamp ultimaActualizacion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.anioEstreno = anioEstreno;
        this.idIdioma = idIdioma;
        this.duracion = duracion;
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getAnioEstreno() { return anioEstreno; }
    public void setAnioEstreno(int anioEstreno) { this.anioEstreno = anioEstreno; }

    public int getIdIdioma() { return idIdioma; }
    public void setIdIdioma(int idIdioma) { this.idIdioma = idIdioma; }

    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }

    public Timestamp getUltimaActualizacion() { return ultimaActualizacion; }
    public void setUltimaActualizacion(Timestamp ultimaActualizacion) { this.ultimaActualizacion = ultimaActualizacion; }

    @Override
    public String toString() {
        return "Pelicula [ID=" + id + ", Título=" + titulo + ", Año=" + anioEstreno + ", Idioma=" + idIdioma +
                ", Duración=" + duracion + " min, Actualización=" + ultimaActualizacion + "]";
    }
}
