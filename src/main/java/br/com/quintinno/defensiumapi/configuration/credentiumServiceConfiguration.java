package br.com.quintinno.defensiumapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class credentiumServiceConfiguration {
	
	@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("credentium", "836a132e3ca04608bafbf55efba878ac");
    }
	
}
