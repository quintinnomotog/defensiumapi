package br.com.quintinno.defensiumapi;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.defensiumapi.utility.DateUtility;

@SpringBootApplication
@RestController
@RequestMapping("/")
@EnableFeignClients(basePackages = "br.com.quintinno.defensiumapi.client")
public class Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Value("${spring.application.version}")
	private String versao;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping
	public Map<String, String> getMensagem() {
		return Map.of(
				"APPLICATION", "DEFENSIUMAPI",
				"PORT", "8080",
				"VERSION", versao,
				"DATE", DateUtility.getDataHoraFormatada());
	}

	@Override
	public void run(String... args) throws Exception {
		logger.warn(getMensagem().toString());
	}

}
