package br.edu.atitus.atitusound.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.atitus.atitusound.dtos.ArtistDTO;
import br.edu.atitus.atitusound.entities.ArtistEntity;
import br.edu.atitus.atitusound.services.ArtistService;
import br.edu.atitus.atitusound.services.GenericService;

@RestController
@RequestMapping("/artists")
public class ArtistController extends GenericController<ArtistEntity, ArtistDTO> {
	
	
	public ArtistController(ArtistService artistService) {
		super();
		this.artistService = artistService;
	}

	private final ArtistService artistService;
	
	protected ArtistEntity convertDTO2Entity(ArtistDTO dto) {
		ArtistEntity entidade = new ArtistEntity();
		BeanUtils.copyProperties(dto, entidade);
		return entidade;
	}

	@Override
	public GenericService<ArtistEntity> getService() {
		return artistService;
	}

	
	
}





