package com.richard.dao.espec;

import com.richard.domain.Profesor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfesorMapper {
    List<Profesor> getAll();

}
