package com.richard.catalogo.data;

import org.apache.ibatis.annotations.*;

import com.richard.catalogo.domain.Curso;

import java.util.List;

@Mapper
public interface CursoMapper {


    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "titulo", property = "titulo"),
            @Result(column = "activo", property = "activo"),
            @Result(column = "horas", property = "horas"),
            @Result(column = "activo", property = "activo"),
            @Result(column = "nivel", property = "nivel"),
            @Result(column = "idProfesor", property = "idProfesor")
    })
    @Select("SELECT * FROM curso WHERE ACTIVO = TRUE")
    List<Curso> getActivos();

    @Insert("INSERT INTO curso (titulo, activo, horas, nivel, idProfesor) " +
            "VALUES (#{titulo}, #{activo}, #{horas}, #{nivel}, #{idProfesor})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Curso curso);

}

