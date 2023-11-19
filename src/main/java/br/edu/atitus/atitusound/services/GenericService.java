package br.edu.atitus.atitusound.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.atitusound.entities.GenericEntity;
import br.edu.atitus.atitusound.repositories.GenericRepository;

public interface GenericService<TEntidade extends GenericEntity> {
	
	GenericRepository<TEntidade> getRepository();
	
	default void validateFindByName(Pageable pageable, String name) {
		
	
	}
	
	default void validateSave(TEntidade entidade)throws Exception{
		if (entidade.getName() == null || entidade.getName().isEmpty())
			throw new Exception("Campo Name Invalido");

		if (entidade.getUuid() == null) {
			if (getRepository().existsByName(entidade.getName()))
				throw new Exception("Ja existe registro com este nome!");
		} else {
			if(!getRepository().existsById(entidade.getUuid()))
				throw new Exception("Registro não encontrado com esse UUID");
			
			if (getRepository().existsByNameAndUuidNot(entidade.getName(), entidade.getUuid()))
				throw new Exception("Ja existe registro com este nome!");
			
		}}

	
	

	default TEntidade save(TEntidade entidade) throws Exception {
		
		validateSave(entidade);

		getRepository().save(entidade);

		return entidade;
	}
	


	default List<TEntidade> findAll() throws Exception {
		
		return getRepository().findAll();
	}


	default Page<List<TEntidade>> findByNameContainingIgnoreCase(Pageable pageable, String name) throws Exception {
		validateFindByName(pageable, name);
		return getRepository().findByNameContainingIgnoreCase(pageable, name);
	}

	default void validateFindById(UUID uuid) {
		
	}
	

	default Optional<TEntidade> findById(UUID uuid) throws Exception {
		validateFindById(uuid);
		return getRepository().findById(uuid);
	}
	
	default void validateDeleteById(UUID uuid)throws Exception {
		if (!getRepository().existsById(uuid))
			throw new Exception("Registro não encontrado com esse UUID");
	}
	

	default void deleteById(UUID uuid) throws Exception {
		validateDeleteById(uuid);
		getRepository().deleteById(uuid);
		
	}
	
	
	
}
