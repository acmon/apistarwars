package br.com.b2w.apistarwars.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.b2w.apistarwars.documents.Planeta;
import br.com.b2w.apistarwars.repositories.PlanetaRepository;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository;
	
	@Override
	public Planeta cadastrar(Planeta planeta) {
		return this.planetaRepository.save(planeta);
	}

	@Override
	public List<Planeta> listar() {
		return this.planetaRepository.findAll();
	}

	@Override
	public List<Planeta> buscarPorNome(String nome) {
		return null;
	}

	@Override
	public Optional<Planeta> buscarPorId(String id) {
		return this.planetaRepository.findById(id);
	}

	@Override
	public void remover(String id) {
		this.planetaRepository.deleteById(id);
	}

}
