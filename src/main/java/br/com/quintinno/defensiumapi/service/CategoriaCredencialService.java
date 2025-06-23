package br.com.quintinno.defensiumapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.quintinno.defensiumapi.mapper.CategoriaCredencialMapper;
import br.com.quintinno.defensiumapi.repository.CategoriaCredencialRepository;
import br.com.quintinno.defensiumapi.tranfer.CategoriaCredencialResponseTransfer;

@Service
public class CategoriaCredencialService {

    private final CategoriaCredencialRepository categoriaCredencialRepository;

    public CategoriaCredencialService(CategoriaCredencialRepository categoriaCredencialRepository) {
        this.categoriaCredencialRepository = categoriaCredencialRepository;
    }

    public List<CategoriaCredencialResponseTransfer> getFindAll() {
        return CategoriaCredencialMapper
                .toCategoriaCredencialResponseTransfer(this.categoriaCredencialRepository.findAll());
    }

}
