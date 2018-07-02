package com.richard.catalogo.service;

import com.richard.catalogo.data.ProfesorMapper;
import com.richard.catalogo.domain.Profesor;
import com.richard.catalogo.service.impl.ProfesorServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ProfesorServiceTest {

    private ProfesorMapper profesorMapper = mock(ProfesorMapper.class);
    private ProfesorService sut = new ProfesorServiceImpl(profesorMapper);

    @Test
    public void alInsertarUnCursoDebemosLlamarAlMapper() {
        List<Profesor> profesoresExpected = mock(List.class);
        doReturn(profesoresExpected).when(profesorMapper).getAll();

        List<Profesor> profesores = sut.getAll();

        verify(profesorMapper).getAll();
        assertThat(profesores, equalTo(profesoresExpected));
    }

}