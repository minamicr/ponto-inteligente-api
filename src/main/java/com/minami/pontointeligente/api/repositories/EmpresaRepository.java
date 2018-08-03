package com.minami.pontointeligente.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.minami.pontointeligente.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	@Transactional(readOnly = true)
	List<Empresa> findByCnpj(String cnpj);

}
