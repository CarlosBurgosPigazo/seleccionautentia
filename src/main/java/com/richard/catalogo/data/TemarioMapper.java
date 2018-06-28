package com.richard.catalogo.data;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.richard.catalogo.domain.Temario;

@Mapper
public interface TemarioMapper {

    @Select("SELECT * FROM TEMARIO WHERE ID=#{id}")
    Temario getTemarioById(long id);

    @Insert("INSERT INTO TEMARIO (id,nombre,extension, bytes)VALUES(#{id},#{nombre},#{extension},#{bytes})")
    void insert(Temario temario);
}
