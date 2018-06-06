package com.richard.controller;

import com.richard.domain.Curso;
import com.richard.domain.Temario;
import com.richard.service.CursoService;
import com.richard.service.TemarioService;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class CursoController implements Serializable {

    @ManagedProperty("#{cursoService}")
    private CursoService cursoService;

    @ManagedProperty("#{temarioService}")
    private TemarioService temarioService;

    private List<Curso> cursos;

    private Curso cursoAInsertar;

    private Temario temarioAsociado;

    private StreamedContent temarioADescargar;

    public CursoService getCursoService() {
        return cursoService;
    }

    @PostConstruct
    public void init() {
        cursos = cursoService.getActivos();
        this.cursoAInsertar = new Curso();
        this.temarioAsociado = new Temario();
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

    public void insertCurrent() {
        //TODO devolver id
        cursoService.insert(cursoAInsertar);
        showMsg("Curso: " + cursoAInsertar.getTitulo() + " insertado");

        if (temarioAsociado.getBytes() != null) {
            temarioAsociado.setId(cursoAInsertar.getId());
            temarioService.insert(temarioAsociado);
            temarioAsociado = new Temario();
        }
        RequestContext currentInstance = RequestContext.getCurrentInstance();
        currentInstance.execute("PF('PF('altaCurso').hide();$('#nuevoCursoForm').trigger('reset')')");
        this.cursos = cursoService.getActivos();
        this.temarioAsociado = new Temario();
    }

    private void showMsg(String msg) {

        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Información", msg));
    }

    public void uploadTemarioEvent(FileUploadEvent event) {
        this.temarioAsociado.setBytes(event.getFile().getContents());
        this.temarioAsociado.setNombre(event.getFile().getFileName());
        this.temarioAsociado.setExtension(event.getFile().getContentType());
        showMsg("Se ha subido el temario correctamente");
    }

    public Curso getCursoAInsertar() {
        return cursoAInsertar;
    }

    public void setCursoAInsertar(Curso cursoAInsertar) {
        this.cursoAInsertar = cursoAInsertar;
    }

    public Temario getTemarioAsociado() {
        return temarioAsociado;
    }

    public void setTemarioAsociado(Temario temarioAsociado) {
        this.temarioAsociado = temarioAsociado;
    }

    public void setTemarioService(TemarioService temarioService) {
        this.temarioService = temarioService;
    }

    public StreamedContent getTemarioADescargar(long id) {
        Temario temario = temarioService.getTemarioById(id);
        if(temario!= null){
          return new DefaultStreamedContent(new ByteArrayInputStream(temario.getBytes()), temario.getExtension(), temario.getNombre());
        }else {
            showMsg("No hay temario asociado para este curso");
            return null;
        }

    }

    public void setTemarioADescargar(StreamedContent temarioADescargar) {
        this.temarioADescargar = temarioADescargar;
    }
}
