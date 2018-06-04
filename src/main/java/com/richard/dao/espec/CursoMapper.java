package com.richard.dao.espec;

import com.richard.domain.Curso;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface CursoMapper {

    List<Curso> getActivos();

    void insert(Curso curso);

}

