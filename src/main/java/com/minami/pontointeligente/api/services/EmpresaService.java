package com.minami.pontointeligente.api.services;

import java.util.Optional;

import com.minami.pontointeligente.api.entities.Empresa;

public interface EmpresaService {

	//retorna uma empresa de acordo com o cnpj
	Optional<Empresa> buscaPorCnpj(String cnpj);
	
	//cadastra uma nova empresa na base de dados
	Empresa persistir(Empresa empresa);
	
}
