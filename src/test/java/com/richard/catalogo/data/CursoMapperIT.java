package com.richard.catalogo.data;

import com.richard.catalogo.config.DataSourceConfig;
import com.richard.catalogo.domain.Curso;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class})
@TestPropertySource("classpath:application-test.properties")
public class CursoMapperIT {

    @Autowired
    private CursoMapper sut;

    @Test
    public void todosLosCursosDeberianSerActivos() {
        boolean sonTodosActivos = sut.getActivos().stream().allMatch(Curso::isActivo);

        assertTrue(sonTodosActivos);
    }

    @Test
    @Transactional
    public void insertandoUnCursoNoActivoNoDeberiaMostrarseEnLosActivos(){
        Curso cursoInactivo = new Curso();
        cursoInactivo.setTitulo("Prueba");
        cursoInactivo.setActivo(false);
        cursoInactivo.setIdProfesor(1);
        cursoInactivo.setHoras(100);
        cursoInactivo.setNivel("Intermedio");

        sut.insert(cursoInactivo);
        boolean contieneCursoInactivo = sut.getActivos().contains(cursoInactivo);

        assertFalse(contieneCursoInactivo);
    }
    @Test
    @Transactional
    public void insertadoUnCursoActivoEsteTieneElUltimoId(){
        Curso cursoAInsertar = new Curso();
        cursoAInsertar.setTitulo("Prueba");
        cursoAInsertar.setActivo(true);
        cursoAInsertar.setIdProfesor(1);
        cursoAInsertar.setHoras(100);
        cursoAInsertar.setNivel("Intermedio");

        sut.insert(cursoAInsertar);
        List<Curso> activos = sut.getActivos();

        assertEquals(activos.get(activos.size()-1 ).getId(), cursoAInsertar.getId());
    }


}
