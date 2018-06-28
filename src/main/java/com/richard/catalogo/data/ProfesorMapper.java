package com.richard.catalogo.data;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.richard.catalogo.domain.Profesor;

import java.util.List;

@Mapper
public interface ProfesorMapper {

    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "nombre", property = "nombre")
    })
    @Select("SELECT * FROM profesor")
    List<Profesor> getAll();

}
