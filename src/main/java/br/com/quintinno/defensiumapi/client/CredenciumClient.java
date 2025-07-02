package br.com.quintinno.defensiumapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "credenciumapi", url = "${integracao.credenciumapi.url}")
public interface CredenciumClient {
	
	@PostMapping("credencium/criptografia/encoder/aes")
	String criptografarChaveSeguranca(@RequestBody String chave);
	
	@PostMapping("credencium/criptografia/decoder/aes")
	String descriptografarChaveSeguranca(@RequestBody String chave);
	
}
