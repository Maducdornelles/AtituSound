package br.edu.atitus.atitusound.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import br.edu.atitus.atitusound.entities.GenericEntity;

@NoRepositoryBean
public interface GenericRepository<TEntidade extends GenericEntity> extends JpaRepository<TEntidade, UUID>{

	boolean existsByNameAndUuidNot(String name, UUID uuid);
	
	boolean existsByName(String name);
	
	Page<List<TEntidade>> findByNameContainingIgnoreCase(Pageable pageable, String name);
	
	//@Query(value = "update tb_artist set name = ?1 where uuid = ?2", nativeQuery = true)
	@Query(value = "update #{#entityName} set name = :name where uuid = :uuid")
	TEntidade updateName(@Param("name") String name,@Param("uuid") UUID uuid);
	
	
	
}
