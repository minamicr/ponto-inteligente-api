package com.minami.pontointeligente.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.minami.pontointeligente.api.entities.Empresa;
import com.minami.pontointeligente.api.repositories.EmpresaRepository;

@SpringBootApplication
public class PontoInteligenteApplication {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PontoInteligenteApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Minami IT3");
			empresa.setCnpj("7465215000104");
			
			this.empresaRepository.save(empresa);
			
			List<Empresa> empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);
			
			Optional<Empresa> empresaDb = empresaRepository.findById(1L);
			System.out.println("Empresa por ID: " + empresaDb);
			
			List<Empresa> empresaCnpj = empresaRepository.findByCnpj("7465215000104");
			System.out.println("empresa por cnpj:" + empresaCnpj.get(0).getCnpj());
			
		};
	}
}
