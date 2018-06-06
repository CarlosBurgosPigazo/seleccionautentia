package com.richard.service;

import com.richard.data.ProfesorMapper;
import com.richard.domain.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("profesorService")
public class ProfesorService {
    private ProfesorMapper profesorMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public ProfesorService(ProfesorMapper profesorMapper) {
        this.profesorMapper = profesorMapper;
    }

    public List<Profesor> getAll() {
        return profesorMapper.getAll();
    }
}
