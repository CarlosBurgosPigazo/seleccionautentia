package com.richard.catalogo.service.impl;

import com.richard.catalogo.data.TemarioMapper;
import com.richard.catalogo.domain.Temario;

import com.richard.catalogo.service.TemarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemarioServiceImpl implements TemarioService {

    private TemarioMapper temarioMapper;

    @Autowired
    public TemarioServiceImpl(TemarioMapper temarioMapper) {
        this.temarioMapper = temarioMapper;
    }

    @Override
    public Temario getTemarioByIdCurso(Long id) {
        return temarioMapper.getTemarioByIdCurso(id);
    }

    @Override
    public void insert(Temario temario) {
        if (temario.getBytes() != null) {
            temarioMapper.insert(temario);
        }
    }
}
