package br.com.b2w.apistarwars.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.b2w.apistarwars.documents.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String>{

}
