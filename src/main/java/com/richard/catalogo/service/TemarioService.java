package com.richard.catalogo.service;

import com.richard.catalogo.domain.Temario;

public interface TemarioService {
    Temario getTemarioByIdCurso(Long id);

    void insert(Temario temario);
}
