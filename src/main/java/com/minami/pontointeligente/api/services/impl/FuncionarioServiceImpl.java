package com.minami.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minami.pontointeligente.api.entities.Funcionario;
import com.minami.pontointeligente.api.repositories.FuncionarioRepository;
import com.minami.pontointeligente.api.services.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class);
	
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario persistir(Funcionario funcionario) {
		log.info("Persistindo fucionário: {}",  funcionario);
		return this.funcionarioRepository.save(funcionario);
	}

	
	public Optional<Funcionario> buscarPorCpf(String cpf) {
		log.info("Buscando funcionário pelo CPF", cpf);
		return Optional.ofNullable(this.funcionarioRepository.findByCpf(cpf));
	}

	
	public Optional<Funcionario> buscarPorEmail(String email) {
		log.info("Buscando funcionário pelo email {}",  email);
		
		return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
	}


	@Override
	public Optional<Funcionario> buscaPorId(Long id) {
		return this.funcionarioRepository.findById(id);
	}



}
