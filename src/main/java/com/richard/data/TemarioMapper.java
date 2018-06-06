package com.richard.data;

import com.richard.domain.Temario;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TemarioMapper {

    @Select("SELECT * FROM TEMARIO WHERE ID=#{id}")
    Temario getTemarioById(long id);

    @Insert("INSERT INTO TEMARIO (id,nombre,extension, bytes)VALUES(#{id},#{nombre},#{extension},#{bytes})")
    void insert(Temario temario);
}
