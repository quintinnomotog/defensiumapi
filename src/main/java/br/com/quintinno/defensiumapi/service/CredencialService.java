package br.com.quintinno.defensiumapi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.defensiumapi.client.CredenciumClient;
import br.com.quintinno.defensiumapi.entity.CredencialEntity;
import br.com.quintinno.defensiumapi.entity.PessoaEntity;
import br.com.quintinno.defensiumapi.exception.NegocioException;
import br.com.quintinno.defensiumapi.mapper.CredencialMapper;
import br.com.quintinno.defensiumapi.repository.CredencialRepository;
import br.com.quintinno.defensiumapi.repository.PessoaRepository;
import br.com.quintinno.defensiumapi.tranfer.CredencialRequestTransfer;
import br.com.quintinno.defensiumapi.tranfer.CredencialResponseTransfer;

@Service
public class CredencialService {

    private static final Logger logger = LoggerFactory.getLogger(CredencialService.class);

    @Autowired
    private CredencialRepository credencialRepository;
    
    @Autowired
    private CredenciumClient credenciumClient;

    @Autowired
    private PessoaRepository pessoaRepository;

    // FIXME: Tratar: HttpMessageNotReadableException;
    // HttpRequestMethodNotSupportedException;
    // InvalidDataAccessApiUsageException;
    public CredencialResponseTransfer create(CredencialRequestTransfer credencialRequestTransfer) {
        
    	if (isCadastrarPessoa(credencialRequestTransfer)) {
    		PessoaEntity pessoaEntity = credencialRequestTransfer.getPessoaEntity();
    			pessoaEntity.setCodePublic(UUID.randomUUID().toString());
            credencialRequestTransfer.setPessoaEntity(pessoaRepository.save(pessoaEntity));
        }
    	
        if (isRegistroDuplicado(credencialRequestTransfer)) {
            throw new NegocioException("Essa Credencial já foi cadastrada!");
        }
        
        logger.info("Criptografando senha via Credencium-Service");
        String senhaCriptografada = credenciumClient.criptografarChaveSeguranca(credencialRequestTransfer.getSenha());
        credencialRequestTransfer.setSenha(senhaCriptografada);
        
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
            throw new NegocioException("Credencial não encontrada!");
        }
        CredencialEntity credencialEntity = CredencialMapper.toCredencialEntity(credencialRequestTransfer, credencialEntityOptional.get());
        this.credencialRepository.save(credencialEntity);
        return CredencialMapper.toCredencialResponseTransfer(credencialEntity);
    }

    private boolean isCadastrarPessoa(CredencialRequestTransfer credencialRequestTransfer) {
        return credencialRequestTransfer.getPessoaEntity() != null &&
                credencialRequestTransfer.getPessoaEntity().getCode() == null &&
                credencialRequestTransfer.getPessoaEntity().getNome() != null;
    }
    
    public String recuperarSenhaDescriptografada(CredencialRequestTransfer credencialRequestTransfer) {
    	Optional.ofNullable(credencialRequestTransfer.getCodePublicCredencial()).filter(code -> !code.isBlank()).orElseThrow(
    			() -> new IllegalArgumentException("O código informado não existe na Base de Dados!"));
    	Optional<CredencialEntity> credencialEntityOptional = this.credencialRepository.findByCodePublic(credencialRequestTransfer.getCodePublicCredencial());
    	if (credencialEntityOptional.isEmpty()) {
    		throw new NegocioException("Credencial Não Encontrada!");
    	}
    	logger.info("Descriptografando senha via Credencium-Service");
    	return credenciumClient.descriptografarChaveSeguranca(credencialEntityOptional.get().getSenha());
    }

}
