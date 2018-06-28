package com.richard.catalogo.data;

import com.richard.catalogo.config.DataSourceConfig;
import com.richard.catalogo.domain.Curso;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class})
public class CursoMapperIT {

    @Autowired
    private CursoMapper cursoMapper;

    @Test
    public void todosLosCursosDeberianSerActivos() { assertTrue(cursoMapper.getActivos().stream().allMatch(Curso::isActivo)); }

    @Test
    public void insertandoUnCursoNoActivoNoDeberiaMostrarseEnLosActivos(){
        Curso cursoAInsertar = new Curso();
        cursoAInsertar.setTitulo("Prueba");
        cursoAInsertar.setActivo(false);
        cursoAInsertar.setIdProfesor(1);
        cursoAInsertar.setHoras(100);
        cursoAInsertar.setNivel("Intermedio");
        cursoMapper.insert(cursoAInsertar);
        System.out.println(cursoAInsertar);
        assertTrue(!cursoMapper.getActivos().contains(cursoAInsertar));
    }
    @Test
    public void insertadoUnCursoActivoEsteTieneElUltimoId(){
        Curso cursoAInsertar = new Curso();
        cursoAInsertar.setTitulo("Prueba");
        cursoAInsertar.setActivo(true);
        cursoAInsertar.setIdProfesor(1);
        cursoAInsertar.setHoras(100);
        cursoAInsertar.setNivel("Intermedio");
        cursoMapper.insert(cursoAInsertar);
        List<Curso> activos = cursoMapper.getActivos();
        assertEquals(activos.get(activos.size()-1 ).getId(), cursoAInsertar.getId());
    }


}