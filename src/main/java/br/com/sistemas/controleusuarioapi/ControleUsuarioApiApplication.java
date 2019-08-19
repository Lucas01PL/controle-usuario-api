package br.com.sistemas.controleusuarioapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@EnableAutoConfiguration
@SpringBootApplication
public class ControleUsuarioApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleUsuarioApiApplication.class, args);
	}

}
