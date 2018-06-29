package com.richard.catalogo.data;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.richard.catalogo.domain.Temario;

@Mapper
public interface TemarioMapper {

    @Select("SELECT * FROM TEMARIO WHERE ID=#{idCurso}")
    Temario getTemarioByIdCurso(Long idCurso);

    @Insert("INSERT INTO TEMARIO (nombre,extension, bytes, idCurso)VALUES(#{nombre},#{extension},#{bytes},#{idCurso})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Temario temario);
}
