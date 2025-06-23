package br.com.quintinno.defensiumapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.quintinno.defensiumapi.entity.CategoriaCredencialEntity;
import br.com.quintinno.defensiumapi.repository.CategoriaCredencialRepository;

@Service
public class CategoriaCredencialService {

    private final CategoriaCredencialRepository categoriaCredencialRepository;

    public CategoriaCredencialService(CategoriaCredencialRepository categoriaCredencialRepository) {
        this.categoriaCredencialRepository = categoriaCredencialRepository;
    }

    public List<CategoriaCredencialEntity> getFindAll() {
        return this.categoriaCredencialRepository.findAll();
    }

}
