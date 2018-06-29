package com.richard.catalogo.service.impl;

import com.richard.catalogo.data.CursoMapper;
import com.richard.catalogo.domain.Curso;
import com.richard.catalogo.domain.Temario;
import com.richard.catalogo.exceptions.InsertarException;
import com.richard.catalogo.service.CursoService;

import com.richard.catalogo.service.TemarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {
    private CursoMapper cursoMapper;
    private TemarioService  temarioService;

    @Autowired
    public CursoServiceImpl(CursoMapper cursoMapper, TemarioService temarioService) {
        this.cursoMapper = cursoMapper;
        this.temarioService = temarioService;
    }
    @Override
    public List<Curso> getActivos() {
        return cursoMapper.getActivos();
    }

    @Override
    public void insert(Curso curso, Temario temario) throws InsertarException {
    	try{
    		cursoMapper.insert(curso);
    		temarioService.insert(temario);
    	}catch (Exception e) {
			throw new InsertarException();
		}
    }


}
