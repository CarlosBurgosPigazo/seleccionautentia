package com.richard.controller;

import com.richard.domain.Curso;
import com.richard.service.CursoService;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class CursoController implements Serializable {

    @ManagedProperty("#{cursoService}")
    private CursoService cursoService;

    private List<Curso> cursos;

    private Curso cursoAInsertar;

    public CursoService getCursoService() {
        return cursoService;
    }

    @PostConstruct
    public void init() {
        cursos = cursoService.getActivos();
        this.cursoAInsertar = new Curso();
    }

    public void setCursoService(CursoService cursoService) {
        this.cursoService = cursoService;

    }

    public List<Curso> getCursos() {
        return this.cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void insert(Curso curso) {
        cursoService.insert(curso);
        this.cursos = cursoService.getActivos();
    }
    public void insertCurrent() {
        cursoService.insert(cursoAInsertar);
        addMessage("Información", "Se ha insertado el curso" );

        RequestContext currentInstance = RequestContext.getCurrentInstance();
        currentInstance.execute("PF('PF('altaCurso').hide();$('#nuevoCursoForm').trigger('reset')')");
        this.cursos = cursoService.getActivos();
    }

    public Curso getCursoAInsertar() {
        return cursoAInsertar;
    }

    public void setCursoAInsertar(Curso cursoAInsertar) {
        this.cursoAInsertar = cursoAInsertar;
    }

    private void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null,message);
    }
}
