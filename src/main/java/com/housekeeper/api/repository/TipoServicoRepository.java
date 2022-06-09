package com.housekeeper.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.housekeeper.api.model.TipoServico;

@Repository
public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {

}
