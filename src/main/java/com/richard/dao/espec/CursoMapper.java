package com.richard.dao.espec;

import com.richard.domain.Curso;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CursoMapper {

    List<Curso> getActivos();

    void insert(Curso curso);

}

