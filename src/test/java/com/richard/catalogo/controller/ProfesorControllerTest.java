package com.richard.catalogo.controller;

import com.richard.catalogo.domain.Profesor;
import com.richard.catalogo.service.ProfesorService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class ProfesorControllerTest {
	private ProfesorService profesorService = mock(ProfesorService.class);
	private ProfesorController sut = new ProfesorController();
	
	
	@Test
	public void alConsultarProfesoresSeDebeDevolverUnaLista() {
        when(profesorService.getAll()).thenReturn(Collections.EMPTY_LIST);
        
        List<Profesor> profesoresSpected = sut.getAll();
        
		assertEquals(profesoresSpected, Collections.EMPTY_LIST);
		
	}
}
