package com.richard.catalogo.service;

import com.richard.catalogo.domain.Curso;
import com.richard.catalogo.domain.Temario;
import com.richard.catalogo.exceptions.InsertarException;

import java.util.List;

public interface CursoService {

     List<Curso> getActivos();

     void insert(Curso curso, Temario temario) throws InsertarException;
}
