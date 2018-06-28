package com.richard.catalogo.service;

import com.richard.catalogo.data.CursoMapper;
import com.richard.catalogo.domain.Curso;
import com.richard.catalogo.service.impl.CursoServiceImpl;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CursoServiceTest {
    private CursoMapper cursoMapper = mock(CursoMapper.class);
    private CursoService sut = new CursoServiceImpl(cursoMapper);

    @Test
    public void alInsertarUnCursoSeDebeDevolverSiEsteEsActivo(){
        Curso curso = new Curso();
        curso.setId(1);
        curso.setActivo(true);
        curso.setHoras(100);
        curso.setIdProfesor(1);
        curso.setNivel("Intermedio");
        curso.setTitulo("Curso avanzado");


    }

}