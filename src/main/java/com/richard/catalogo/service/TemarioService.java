package com.richard.catalogo.service;

import com.richard.catalogo.domain.Temario;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface TemarioService {
    Temario getTemarioById(long id);

    void insert(Temario temario);
}
