package br.edu.atitus.atitusound.servicesimpl;


import org.springframework.stereotype.Service;

import br.edu.atitus.atitusound.entities.ArtistEntity;
import br.edu.atitus.atitusound.repositories.ArtistRepository;
import br.edu.atitus.atitusound.repositories.GenericRepository;
import br.edu.atitus.atitusound.services.ArtistService;

@Service
public class ArtistServiceImpl implements ArtistService {

	private final ArtistRepository artistrepository;

	public ArtistServiceImpl(ArtistRepository artistrepository) {
		super();
		this.artistrepository = artistrepository;
	}

	@Override
	public GenericRepository<ArtistEntity> getRepository() {
		return artistrepository;
	}
	
	

}