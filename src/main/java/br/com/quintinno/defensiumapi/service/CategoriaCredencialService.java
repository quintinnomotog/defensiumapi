package br.com.quintinno.defensiumapi.service;

import br.com.quintinno.defensiumapi.entity.CategoriaCredencialEntity;
import br.com.quintinno.defensiumapi.mapper.CategoriaCredencialMapper;
import br.com.quintinno.defensiumapi.repository.CategoriaCredencialRepository;
import br.com.quintinno.defensiumapi.tranfer.CategoriaCredencialRequestTransfer;
import br.com.quintinno.defensiumapi.tranfer.CategoriaCredencialResponseTransfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaCredencialService {

    private final Logger log = LoggerFactory.getLogger(CategoriaCredencialService.class);

    private final CategoriaCredencialRepository categoriaCredencialRepository;

    public CategoriaCredencialService(CategoriaCredencialRepository categoriaCredencialRepository) {
        this.categoriaCredencialRepository = categoriaCredencialRepository;
    }

    @Cacheable("categoriaCredencial")
    public List<CategoriaCredencialResponseTransfer> getFindAll() {
        log.info("[DefensiumService -> CategoriaCredencialService.class]: Pesquisando na Base de Dados!");
        return CategoriaCredencialMapper
                .toCategoriaCredencialResponseTransfer(this.categoriaCredencialRepository.findAll());
    }

    public CategoriaCredencialResponseTransfer create(CategoriaCredencialRequestTransfer categoriaCredencialRequestTransfer) {
        CategoriaCredencialEntity categoriaCredencialEntity = CategoriaCredencialMapper.toCategoriaCredencialEntity(categoriaCredencialRequestTransfer);
        this.categoriaCredencialRepository.save(categoriaCredencialEntity);
        return CategoriaCredencialMapper.fromCategoriaCredencialResponseTransfer(categoriaCredencialEntity);
    }

}
