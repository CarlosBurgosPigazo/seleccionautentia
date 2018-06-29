package com.richard.catalogo.controller;

import com.richard.catalogo.data.CursoMapper;
import com.richard.catalogo.domain.Curso;
import com.richard.catalogo.service.CursoService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CursoControllerTest {
    private CursoService cursoService = mock(CursoService.class);
    private CursoController sut = new CursoController();

    @Before
    public void setUp() throws Exception {
        sut.setCursoService(cursoService);
    }
    @Test
    public void insertandoElCursoActualSeDebeLlamarAlMApper(){
        Curso curso = mock(Curso.class);
        sut.setCursoAInsertar(curso);

        sut.insertCurrent();

        
    }
}