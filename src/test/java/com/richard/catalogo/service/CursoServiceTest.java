package com.richard.catalogo.service;

import com.richard.catalogo.data.CursoMapper;
import com.richard.catalogo.domain.Curso;
import com.richard.catalogo.exceptions.InsertarException;
import com.richard.catalogo.service.impl.CursoServiceImpl;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CursoServiceTest {

    private CursoMapper cursoMapper = mock(CursoMapper.class);
    private CursoService sut = new CursoServiceImpl(cursoMapper);

    @Test
    public void alInsertarUnCursoDebemosLlamarAlMapper() throws InsertarException{
        Curso curso = mock(Curso.class);

        sut.insert(curso);
        
        verify(cursoMapper).insert(curso);
    }

    @Test(expected=InsertarException.class)
    public void alInsertarUnCursoSiFallaElMapperLanzamosExcepcion() throws InsertarException{
        Curso curso = mock(Curso.class);
        doThrow(RuntimeException.class).when(cursoMapper).insert(curso);

        sut.insert(curso);
    }
}