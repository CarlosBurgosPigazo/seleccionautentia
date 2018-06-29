package com.richard.catalogo.service;

import com.richard.catalogo.data.CursoMapper;
import com.richard.catalogo.data.TemarioMapper;
import com.richard.catalogo.domain.Curso;
import com.richard.catalogo.domain.Temario;
import com.richard.catalogo.exceptions.InsertarException;
import com.richard.catalogo.service.impl.CursoServiceImpl;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CursoServiceTest {

    private CursoMapper cursoMapper = mock(CursoMapper.class);
    private TemarioService temarioService = mock(TemarioService.class);
    private CursoService sut = new CursoServiceImpl(cursoMapper, temarioService);

    @Test
    public void alInsertarUnCursoDebemosLlamarAlMapper() throws InsertarException{
        Curso curso = mock(Curso.class);
        Temario temario = mock(Temario.class);

        sut.insert(curso, temario);
        
        verify(cursoMapper).insert(curso);
        verify(temarioService).insert(temario);
    }

    @Test(expected=InsertarException.class)
    public void alInsertarUnCursoSiFallaElMapperLanzamosExcepcion() throws InsertarException{
        Curso curso = mock(Curso.class);
        Temario temario = mock(Temario.class);
        doThrow(RuntimeException.class).when(cursoMapper).insert(curso);

        sut.insert(curso,temario);
    }
}