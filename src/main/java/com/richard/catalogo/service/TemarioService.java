package com.richard.catalogo.service;

import com.richard.catalogo.data.TemarioMapper;
import com.richard.catalogo.domain.Temario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("temarioService")
public class TemarioService {

    private TemarioMapper temarioMapper;

    @Autowired
    public TemarioService(TemarioMapper temarioMapper){
        this.temarioMapper = temarioMapper;
    }

    public Temario getTemarioById(long id) {
        return temarioMapper.getTemarioById(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert(Temario temario) {
        temarioMapper.insert(temario);
    }
}
