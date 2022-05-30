package com.housekeeper.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.housekeeper.api.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByEmail(String email);

	@Query("select u from Usuario u join u.tipoServicos t where t.id = :id")
	List<Usuario> findAllByTipoServicos(@Param("id") Long id);
	
}
