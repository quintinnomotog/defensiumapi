package br.com.quintinno.defensiumapi.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.defensiumapi.entity.CredencialEntity;
import br.com.quintinno.defensiumapi.exception.NegocioException;
import br.com.quintinno.defensiumapi.mapper.CredencialMapper;
import br.com.quintinno.defensiumapi.repository.CredencialRepository;
import br.com.quintinno.defensiumapi.tranfer.CredencialRequestTransfer;
import br.com.quintinno.defensiumapi.tranfer.CredencialResponseTransfer;

@Service
public class CredencialService {

    private static final Logger logger = LoggerFactory.getLogger(CredencialService.class);

    @Autowired
    private CredencialRepository credencialRepository;

    // FIXME: Tratar: HttpMessageNotReadableException;
    // HttpRequestMethodNotSupportedException;
    // InvalidDataAccessApiUsageException;
    public CredencialResponseTransfer create(CredencialRequestTransfer credencialRequestTransfer) {
        if (isRegistroDuplicado(credencialRequestTransfer)) {
            throw new NegocioException("Essa Credencial já foi cadastrada!");
        }
        logger.info("Persistindo nova Credencial na Base de Dados!");
        return CredencialMapper
                .toCredencialResponseTransfer(
                        this.credencialRepository.save(CredencialMapper.toCredencialEntity(credencialRequestTransfer)));
    }

    private boolean isRegistroDuplicado(CredencialRequestTransfer credencialRequestTransfer) {
        logger.info("Verificando credencial duplicada!");
        return this.credencialRepository.existsByCategoriaCredencialEntityAndPessoaEntityAndIdentificador(
                credencialRequestTransfer.getCategoriaCredencialEntity(),
                credencialRequestTransfer.getPessoaEntity(),
                credencialRequestTransfer.getIdentificador());
    }

    public List<CredencialResponseTransfer> findAll() {
        List<CredencialEntity> credencialEntityList = this.credencialRepository.findAll();
        return CredencialMapper.toCredencialResponseTransfer(credencialEntityList);
    }

    public CredencialResponseTransfer update(CredencialRequestTransfer credencialRequestTransfer) {
        Optional<CredencialEntity> credencialEntityOptional = this.credencialRepository.findByCodePublic(credencialRequestTransfer.getCodePublicCredencial());
        if (!credencialEntityOptional.isPresent()) {
            new NegocioException("Credencial não encontrada!");
        }
        if (isRegistroDuplicado(credencialRequestTransfer)) {
            throw new NegocioException("Essa Credencial já foi cadastrada!");
        }
        return CredencialMapper
                .toCredencialResponseTransfer(
                        this.credencialRepository.save(
                                CredencialMapper.toCredencialEntity(credencialRequestTransfer)));
    }

}
