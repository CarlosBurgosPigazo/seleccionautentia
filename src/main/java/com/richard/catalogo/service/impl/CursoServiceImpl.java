package com.richard.catalogo.service.impl;

import com.richard.catalogo.data.CursoMapper;
import com.richard.catalogo.domain.Curso;
import com.richard.catalogo.exceptions.InsertarException;
import com.richard.catalogo.service.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void insert(Curso curso) throws InsertarException {
    	try{
    		cursoMapper.insert(curso);
    	}catch (Exception e) {
			throw new InsertarException();
		}
    }


}
