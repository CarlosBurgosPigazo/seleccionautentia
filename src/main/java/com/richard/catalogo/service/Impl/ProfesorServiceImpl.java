package com.richard.catalogo.service.Impl;

import com.richard.catalogo.data.ProfesorMapper;
import com.richard.catalogo.domain.Profesor;

import com.richard.catalogo.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    private ProfesorMapper profesorMapper;

    @Autowired
    public ProfesorServiceImpl(ProfesorMapper profesorMapper) {
        this.profesorMapper = profesorMapper;
    }

    @Override
    public List<Profesor> getAll() {
        return profesorMapper.getAll();
    }
}
