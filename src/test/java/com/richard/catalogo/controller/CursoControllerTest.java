package com.richard.catalogo.controller;

import com.richard.catalogo.data.CursoMapper;
import com.richard.catalogo.service.CursoService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CursoControllerTest {
    private CursoService cursoService = mock(CursoService.class);
    private CursoController sut = new CursoController();

    @Before
    public void setUp() throws Exception {
        sut.setCursoService(cursoService);
    }
    @Test
}