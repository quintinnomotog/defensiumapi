package br.com.quintinno.defensiumapi.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.quintinno.defensiumapi.exception.NegocioException;

@Component
public class CredenciumFallbackClient implements CredenciumClient {

    private Logger log = LoggerFactory.getLogger(CredenciumFallbackClient.class);

    @Override
    public String criptografarChaveSeguranca(String chave) {
        log.error("Serviço Credencium indisponível para criptografia da chave: {}", chave);
        throw new NegocioException("Falha ao tentar criptografar a senha, pois o CredenciumService não está disponível.");
    }

    @Override
    public String descriptografarChaveSeguranca(String chave) {
        log.error("Serviço Credencium (autenticação) indisponível para descriptografar da chave: {}", chave);
        throw new NegocioException("Falha ao tentar descriptografar a senha, pois o CredenciumService não está disponível.");
    }

}
