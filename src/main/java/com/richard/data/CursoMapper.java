package com.richard.data;

import com.richard.domain.Curso;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Insert("INSERT INTO CURSO (titulo, activo, horas, nivel, idProfesor) " +
            "VALUES (#{titulo}, #{activo}, #{horas}, #{nivel}, #{idProfesor})")
    void insert(Curso curso);

}
