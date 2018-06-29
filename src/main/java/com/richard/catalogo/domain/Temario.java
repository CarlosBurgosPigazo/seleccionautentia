package com.richard.catalogo.domain;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class Temario {
    private long id;
    private String nombre;
    private String extension;
    private byte[] bytes;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temario temario = (Temario) o;
        return id == temario.id &&
                Objects.equals(nombre, temario.nombre) &&
                Objects.equals(extension, temario.extension) &&
                Arrays.equals(bytes, temario.bytes);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, nombre, extension);
        result = 31 * result + Arrays.hashCode(bytes);
        return result;
    }
}
