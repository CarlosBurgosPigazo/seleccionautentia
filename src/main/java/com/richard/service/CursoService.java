package com.richard.service;

import com.richard.data.CursoMapper;
import com.richard.domain.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cursoService")
public class CursoService {
    private CursoMapper cursoMapper;

    @Autowired
    public CursoService(CursoMapper cursoMapper) {
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
