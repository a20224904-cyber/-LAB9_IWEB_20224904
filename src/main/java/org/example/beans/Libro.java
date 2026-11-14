package org.example.beans;

public class Libro {
    private Integer id_libro;
    private Genero genero;
    private String titulo;
    private String autor;
    private Integer anio_publlicacion;

    public Integer getId_libro() {
        return id_libro;
    }

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnio_publlicacion() {
        return anio_publlicacion;
    }

    public void setAnio_publlicacion(Integer anio_publlicacion) {
        this.anio_publlicacion = anio_publlicacion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
