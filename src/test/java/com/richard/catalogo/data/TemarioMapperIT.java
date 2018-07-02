package com.richard.catalogo.data;

import com.richard.catalogo.config.DataSourceConfig;
import com.richard.catalogo.domain.Temario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class})
@TestPropertySource("classpath:application-test.properties")
public class TemarioMapperIT {
    @Autowired
    private TemarioMapper temarioMapper;

    @Test
    @Transactional
    public void alInsertarYUnCursoDebeGuardarse(){
        Temario temario = new Temario();
        temario.setExtension("text/plain");
        temario.setBytes("test".getBytes());
        temario.setNombre("test");
        temario.setId(1L);
        temario.setIdCurso(1L);

        temarioMapper.insert(temario);
        Temario temarioFromDB = temarioMapper.getTemarioByIdCurso(temario.getId());

        assertEquals(temario, temarioFromDB);
    }


}