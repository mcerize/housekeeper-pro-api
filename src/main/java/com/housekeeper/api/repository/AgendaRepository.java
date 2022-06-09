package com.housekeeper.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.housekeeper.api.model.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
	
	List<Agenda> findAllByIdPrestadorServico(@Param("id") Long id);
	
	List<Agenda> findAllByIdCliente(@Param("id") Long id);
	
	@Query("select a from Agenda a where a.idPrestadorServico = :idUsuario and a.idTipoServico = :idTipoServico and a.idCliente is null order by a.dataServico")
	List<Agenda> findAllByIdUsuarioIdPrestadorServico(@Param("idUsuario") Long idUsuario, @Param("idTipoServico") Long idTipoServico);

}
