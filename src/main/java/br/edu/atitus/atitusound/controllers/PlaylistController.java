package br.edu.atitus.atitusound.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.atitusound.dtos.PlaylistDTO;
import br.edu.atitus.atitusound.entities.PlaylistEntity;
import br.edu.atitus.atitusound.services.GenericService;
import br.edu.atitus.atitusound.services.PlaylistService;

@RestController
@RequestMapping("/playlists")
public class PlaylistController extends GenericController<PlaylistEntity, PlaylistDTO>{

	private final PlaylistService service;
	
	public PlaylistController(PlaylistService service) {
		super();
		this.service = service;
	}
	
	@Override
	public GenericService<PlaylistEntity> getService() {
		return service;
	}

	@Override
	protected PlaylistEntity convertDTO2Entity(PlaylistDTO dto) {
		PlaylistEntity entidade = new PlaylistEntity();
		
		entidade.setName(dto.getName());
		entidade.setPublic_share(dto.getPublic_share());
		
		return entidade;
	}

	
}
