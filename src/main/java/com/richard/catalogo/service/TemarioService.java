package com.richard.catalogo.service;

import com.richard.catalogo.domain.Temario;

public interface TemarioService {
    Temario getTemarioById(long id);

    void insert(Temario temario);
}
