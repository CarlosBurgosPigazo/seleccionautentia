package com.richard.service;

import com.richard.dao.espec.CursoMapper;
import com.richard.domain.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    private CursoMapper cursoMapper;

    @Autowired
    public CursoService(CursoMapper cursoMapper) {
        this.cursoMapper = cursoMapper;
    }

    public List<Curso> getActivos() {
        return cursoMapper.getActivos();
    }


    public void insert(Curso curso) {
        cursoMapper.insert(curso);
    }
}
