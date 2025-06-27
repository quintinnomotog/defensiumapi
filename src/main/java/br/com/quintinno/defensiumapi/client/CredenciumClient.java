package br.com.quintinno.defensiumapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.quintinno.defensiumapi.configuration.CredenciumServiceConfiguration;

@FeignClient(name = "credenciumapi", url = "${integracao.credenciumapi.url}", configuration = CredenciumServiceConfiguration.class)
public interface CredenciumClient {
	
	@PostMapping("credencium/criptografia/encoder/aes")
	String criptografarChaveSeguranca(@RequestBody String chave);
	
}
