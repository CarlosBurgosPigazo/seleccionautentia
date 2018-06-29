package com.richard.catalogo.service;

import com.richard.catalogo.data.TemarioMapper;
import com.richard.catalogo.domain.Temario;
import com.richard.catalogo.service.TemarioService;
import com.richard.catalogo.service.impl.TemarioServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TemarioServiceTest {
    private TemarioMapper temarioMapper =mock(TemarioMapper.class);
    private TemarioService sut =new TemarioServiceImpl(temarioMapper);

    @Test
    public void alInsertarSeDebeLlamaAlMapper(){
        Temario temario= mock(Temario.class);

        sut.insert(temario);

        verify(temarioMapper).insert(temario);
    }

    @Test
    public void alConsultarUnCursoSeDebeLlamarAlMapper(){
        Long idCurso=1L;

        sut.getTemarioByIdCurso(idCurso);

        verify(temarioMapper).getTemarioByIdCurso(idCurso);
    }

}