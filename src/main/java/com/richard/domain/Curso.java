package com.richard.domain;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class Curso {
    private long id;
    private String titulo;
    private boolean activo;
    private long idProfesor;
    private int horas;
    private String nivel;
    private File temario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public File getTemario() {
        return temario;
    }

    public void setTemario(File temario) {
        this.temario = temario;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", activo=" + activo +
                ", idProfesor=" + idProfesor +
                ", horas=" + horas +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}
