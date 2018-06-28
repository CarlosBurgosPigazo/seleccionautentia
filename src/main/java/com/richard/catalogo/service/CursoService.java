package com.richard.catalogo.service;

import com.richard.catalogo.domain.Curso;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CursoService {

     List<Curso> getActivos();

     void insert(Curso curso);
}
