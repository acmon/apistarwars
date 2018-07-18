package br.com.b2w.apistarwars.services;

import java.util.List;
import java.util.Optional;

import br.com.b2w.apistarwars.documents.Planeta;

public interface PlanetaService {

	Planeta cadastrar(Planeta planeta);
	List<Planeta> listar();
	List<Planeta> buscarPorNome(String nome);
	Optional<Planeta> buscarPorId(String id);
	void remover(String id);
}
