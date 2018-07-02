package com.richard.catalogo.controller;

import com.richard.catalogo.domain.Curso;
import com.richard.catalogo.domain.Temario;
import com.richard.catalogo.service.CursoService;
import com.richard.catalogo.service.TemarioService;
import org.junit.Before;
import org.junit.Test;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CursoControllerTest {
    private CursoService cursoService = mock(CursoService.class);
    private TemarioService temarioService = mock(TemarioService.class);
    private CursoController sut = new CursoController();

    @Before
    public void setUp() throws Exception {
        sut.setCursoService(cursoService);
        sut.setTemarioService(temarioService);
        sut.init();
    }

    @Test
    public void alInsertarUnCursoElCursoAInsertarSeDebeResetear() {
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
    public void alSubirUnArchivoElTemarioActualDebeActualizarseCorrectamente() {
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

    @Test
    public void alSolicitarUnTemarioNoExistenteSeDevuelveNull() {
        when(temarioService.getTemarioByIdCurso(1L)).thenReturn(null);

        StreamedContent temarioADescargar = sut.getTemarioADescargar(1);

        assertNull(temarioADescargar);
    }

    @Test
    public void alSolicitarUnTemarioExistenteSeDevuelveDefaultStreamedContent() {
        Temario temario = new Temario();
        temario.setIdCurso(1L);
        temario.setId(1L);
        temario.setBytes("test".getBytes());
        temario.setNombre("test.txt");
        temario.setExtension("text/plain");
        when(temarioService.getTemarioByIdCurso(1L)).thenReturn(temario);

        StreamedContent temarioADescargar = sut.getTemarioADescargar(1);

        assertTrue(temarioADescargar instanceof DefaultStreamedContent);
    }

}