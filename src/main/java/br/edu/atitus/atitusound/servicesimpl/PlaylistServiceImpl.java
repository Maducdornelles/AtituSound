package br.edu.atitus.atitusound.servicesimpl;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.edu.atitus.atitusound.entities.PlaylistEntity;
import br.edu.atitus.atitusound.entities.UserEntity;
import br.edu.atitus.atitusound.repositories.GenericRepository;
import br.edu.atitus.atitusound.repositories.PlaylistRepository;
import br.edu.atitus.atitusound.services.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{
	
	private final PlaylistRepository repository;
	
	public PlaylistServiceImpl(PlaylistRepository repository) {
		super();
		this.repository = repository;
	}


	@Override
	public GenericRepository<PlaylistEntity> getRepository() {
		return repository;
	}


	@Override
	public void validateSave(PlaylistEntity entity) throws Exception {
		PlaylistService.super.validateSave(entity);
		UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		entity.setUser(user);
	}


	@Override
	public Page<List<PlaylistEntity>> findByNameContainingIgnoreCase(Pageable pageable, String name) throws Exception {
		
		UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return repository.findByNameContainingIgnoreCaseAndUserOrPublicshare(name, user, true, pageable);
	}

}
