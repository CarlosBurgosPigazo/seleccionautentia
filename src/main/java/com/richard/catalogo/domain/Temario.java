package com.richard.catalogo.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

@Component
public class Temario {
    private long id;
    private String nombre;
    private String extension;
    private byte[] bytes;
    private Long idCurso;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Temario temario = (Temario) o;

        return new EqualsBuilder()
                .append(id, temario.id)
                .append(nombre, temario.nombre)
                .append(extension, temario.extension)
                .append(bytes, temario.bytes)
                .append(idCurso, temario.idCurso)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(nombre)
                .append(extension)
                .append(bytes)
                .append(idCurso)
                .toHashCode();
    }
}
