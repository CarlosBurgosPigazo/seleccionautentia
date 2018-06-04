package com.richard.controller;

import com.richard.domain.Curso;
import com.richard.service.CursoService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class CursoController implements Serializable {
    @ManagedProperty("#{cursoService}")
    private CursoService cursoService;

    public CursoService getCursoService() {
        return cursoService;
    }

    public void setCursoService(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    private List<Curso> cursos;

    @PostConstruct
    public void init(){
        cursos = cursoService.getActivos();
    }

    public List<Curso> getActivos() {
        return cursoService.getActivos();
    }

    public void insert(Curso curso) {
        cursoService.insert(curso);
    }
}
