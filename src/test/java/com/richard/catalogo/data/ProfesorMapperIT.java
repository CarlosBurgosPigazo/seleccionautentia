package com.richard.catalogo.data;

import com.richard.catalogo.config.DataSourceConfig;
import com.richard.catalogo.domain.Profesor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class})
@TestPropertySource("classpath:application-test.properties")
public class ProfesorMapperIT {
    @Autowired
    private ProfesorMapper profesorMapper;

    @Test
    public void recuperarTodosDeberiaDevolverUnaListaDeProfesores(){
        Profesor profesorExpected = new Profesor();
        profesorExpected.setId(1);
        profesorExpected.setNombre("Roberto Canales Mora");

        List<Profesor> profesores = profesorMapper.getAll();

        assertThat(profesores.size(), greaterThan(6));
        assertThat(profesores, hasItem(profesorExpected));

    }
}