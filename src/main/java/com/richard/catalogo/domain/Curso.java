package com.richard.catalogo.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

@Component
public class Curso {
    private long id;
    private String titulo;
    private boolean activo;
    private long idProfesor;
    private int horas;
    private String nivel;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("titulo", titulo)
                .append("activo", activo)
                .append("idProfesor", idProfesor)
                .append("horas", horas)
                .append("nivel", nivel)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Curso curso = (Curso) o;

        return new EqualsBuilder()
                .append(id, curso.id)
                .append(activo, curso.activo)
                .append(idProfesor, curso.idProfesor)
                .append(horas, curso.horas)
                .append(titulo, curso.titulo)
                .append(nivel, curso.nivel)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(titulo)
                .append(activo)
                .append(idProfesor)
                .append(horas)
                .append(nivel)
                .toHashCode();
    }
}
