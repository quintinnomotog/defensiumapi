package br.com.quintinno.defensiumapi;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping
	public String getMensagem() {
		HashMap apiMap = new HashMap<>();
			apiMap.put("APPLICATION", "DEFENSIUMAPI");
			apiMap.put("VERSION", "v1.0.0");
			apiMap.put("PORT", "8080");
		return apiMap.toString();
	}

}
