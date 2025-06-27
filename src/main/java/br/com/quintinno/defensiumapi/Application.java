package br.com.quintinno.defensiumapi;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
@EnableFeignClients(basePackages = "br.com.quintinno.defensiumapi.client")
public class Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping
	public String getMensagem() {
		HashMap apiMap = new HashMap<>();
			apiMap.put("APPLICATION", "DEFENSIUMAPI");
			apiMap.put("PORT", "8080");
			apiMap.put("VERSION", "v1.4.0.0");
		return apiMap.toString();
	}

	@Override
	public void run(String... args) throws Exception {
		logger.warn(getMensagem());
	}

}
