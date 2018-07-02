package com.richard.catalogo.controller;

import com.richard.catalogo.domain.Curso;
import com.richard.catalogo.domain.Temario;
import com.richard.catalogo.service.CursoService;
import org.junit.Before;
import org.junit.Test;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CursoControllerTest {
    private CursoService cursoService = mock(CursoService.class);
    private CursoController sut = new CursoController();

    @Before
    public void setUp() throws Exception {
        sut.setCursoService(cursoService);
        sut.init();
    }
    @Test
    public void alInsertarUnCursoElCursoAInsertarSeDebeResetear(){
        Curso curso = new Curso();
        curso.setId(1);
        curso.setNivel("Intermedio");
        curso.setIdProfesor(1);
        curso.setTitulo("JAVA 05");
        Curso cursoEsperado = new Curso();

        sut.setCursoAInsertar(curso);
        sut.insertCurrent();

        assertEquals(cursoEsperado, sut.getCursoAInsertar());

    }
    @Test
    public void alSubirUnArchivoElTemarioActualDebeActualizarseCorrectamente(){
        FileUploadEvent evento = mock(FileUploadEvent.class);
        UploadedFile fichero = mock(UploadedFile.class);
        when(evento.getFile()).thenReturn(fichero);
        when(fichero.getContentType()).thenReturn("text/plain");
        when(fichero.getContents()).thenReturn("test".getBytes());
        when(fichero.getFileName()).thenReturn("test.txt");

        sut.uploadTemarioEvent(evento);

        Temario temarioAsociado = sut.getTemarioAsociado();
        assertEquals(temarioAsociado.getExtension(), "text/plain");
        assertTrue(Arrays.equals(temarioAsociado.getBytes(), "test".getBytes()));
        assertEquals(temarioAsociado.getNombre(), "test.txt");
    }
}