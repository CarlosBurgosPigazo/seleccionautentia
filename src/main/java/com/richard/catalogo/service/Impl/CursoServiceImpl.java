package com.richard.catalogo.service.Impl;

import com.richard.catalogo.data.CursoMapper;
import com.richard.catalogo.domain.Curso;
import com.richard.catalogo.service.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {
    private CursoMapper cursoMapper;

    @Autowired
    public CursoServiceImpl(CursoMapper cursoMapper) {
        this.cursoMapper = cursoMapper;
    }

    public List<Curso> getActivos() {
        return cursoMapper.getActivos();
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert(Curso curso) {
         cursoMapper.insert(curso);
    }


}
