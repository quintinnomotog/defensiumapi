package br.com.quintinno.defensiumapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.defensiumapi.mapper.CredencialMapper;
import br.com.quintinno.defensiumapi.repository.CredencialRepository;
import br.com.quintinno.defensiumapi.tranfer.CredencialRequestTransfer;
import br.com.quintinno.defensiumapi.tranfer.CredencialResponseTransfer;

@Service
public class CredencialService {

    private static final Logger logger = LoggerFactory.getLogger(CredencialService.class);

    @Autowired
    private CredencialRepository credencialRepository;

    public CredencialResponseTransfer create(CredencialRequestTransfer credencialRequestTransfer) {
        // Validar se reristro duplicado (Mesma: Categoria, Pessoa, identificador)
        // Tratar: HttpMessageNotReadableException, InvalidDataAccessApiUsageException, 
        logger.info("Persistindo nova Credencial na Base de Dados");
        return CredencialMapper
                .toCredencialResponseTransfer(
                        this.credencialRepository.save(CredencialMapper.toCredencialEntity(credencialRequestTransfer)));
    }

}
