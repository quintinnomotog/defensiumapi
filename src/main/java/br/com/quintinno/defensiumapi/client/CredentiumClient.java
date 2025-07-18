package br.com.quintinno.defensiumapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "credentiumapi")
public interface CredentiumClient {
	
	@PostMapping("credentium/criptografia/encoder/aes")
	String criptografarChaveSeguranca(@RequestBody String chave);
	
	@PostMapping("credentium/criptografia/decoder/aes")
	String descriptografarChaveSeguranca(@RequestBody String chave);
	
}
