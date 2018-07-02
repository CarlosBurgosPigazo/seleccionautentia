package com.richard.catalogo.controller;

import com.richard.catalogo.domain.Curso;
import com.richard.catalogo.service.CursoService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;



public class CursoControllerTest {
    private CursoService cursoService = mock(CursoService.class);
    private CursoController sut = new CursoController();

    @Before
    public void setUp() throws Exception {
        sut.setCursoService(cursoService);
    }
    @Test
    public void alInsertarUnCursoElCursoAInsertarSeDebeResetear(){
        Curso curso = new Curso();
        curso.setId(1);
        curso.setNivel("Intermedio");
        curso.setIdProfesor(1);
        curso.setTitulo("JAVA 05");
        Curso cursoEsperado = new Curso();

        sut.setCursoAInsertar(curso);
        sut.insertCurrent();

        assertEquals(cursoEsperado, sut.getCursoAInsertar());

    }
}