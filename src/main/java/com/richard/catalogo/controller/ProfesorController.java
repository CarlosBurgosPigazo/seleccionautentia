package com.richard.catalogo.controller;

import com.richard.catalogo.domain.Profesor;
import com.richard.catalogo.service.ProfesorService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class ProfesorController implements Serializable {


    private List<Profesor> profesores;

    @ManagedProperty("#{profesorService}")
    private ProfesorService profesorService;

    public ProfesorService getProfesorService() {
        return profesorService;
    }

    public void setProfesorService(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @PostConstruct
    public void init() {
        this.profesores = profesorService.getAll();
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }


    public List<Profesor> getAll() {
        return profesorService.getAll();
    }

}
