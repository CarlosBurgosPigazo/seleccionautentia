package com.richard.data;

import com.richard.config.DataSourceConfig;
import com.richard.domain.Curso;
import com.richard.service.CursoService;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.CoreMatchers.*;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class})
public class CursoServiceTest {

    @Autowired
    private CursoService cursoService;

    @Test
    public void todosLosCursosDeberianSerActivos() { assertTrue(cursoService.getActivos().stream().allMatch(Curso::isActivo)); }

    @Test
    public void insertandoUnCursoNoActivoNoDeberiaMostrarseEnLosActivos(){
        Curso cursoAInsertar = new Curso();
        cursoAInsertar.setTitulo("Prueba");
        cursoAInsertar.setActivo(false);
        cursoAInsertar.setIdProfesor(1);
        cursoAInsertar.setHoras(100);
        cursoAInsertar.setNivel("Intermedio");
        cursoService.insert(cursoAInsertar);
        System.out.println(cursoAInsertar);
        assertTrue(!cursoService.getActivos().contains(cursoAInsertar));
    }
    @Test
    public void insertadoUnCursoActivoEsteTieneElUltimoId(){
        Curso cursoAInsertar = new Curso();
        cursoAInsertar.setTitulo("Prueba");
        cursoAInsertar.setActivo(true);
        cursoAInsertar.setIdProfesor(1);
        cursoAInsertar.setHoras(100);
        cursoAInsertar.setNivel("Intermedio");
        cursoService.insert(cursoAInsertar);
        List<Curso> activos = cursoService.getActivos();
        assertEquals(activos.get(activos.size()-1 ).getId(), cursoAInsertar.getId());
    }


}
