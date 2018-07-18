package br.com.b2w.apistarwars.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.b2w.apistarwars.documents.Planeta;
import br.com.b2w.apistarwars.responses.Response;
import br.com.b2w.apistarwars.services.PlanetaService;

@RestController
@RequestMapping(path = "/api/v1/planetas")
public class PlanetaController {
	
	@Autowired
	private PlanetaService planetaService;

	@GetMapping
	public ResponseEntity<Response<List<Planeta>>> listar() {
		return ResponseEntity.ok(new Response<List<Planeta>>(this.planetaService.listar()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Planeta>> buscarPorId(@PathVariable(name = "id") String id) {
		
		Planeta planeta = this.planetaService.buscarPorId(id)
							.orElse(null);
		
		if (planeta == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(new Response<Planeta>(planeta));
	}
	
	@GetMapping(path = "/nome/{nome}")
	public ResponseEntity<List<Planeta>> buscarPorNome(@PathVariable(name = "nome") String nome) {
		return ResponseEntity.ok(this.planetaService.buscarPorNome(nome));
	}
	
	@PostMapping
	public ResponseEntity<Response<Planeta>> cadastrar(@Valid @RequestBody Planeta planeta, BindingResult result) {
		
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(new Response<Planeta>(erros));
		}
		
		return ResponseEntity.ok(new Response<Planeta>(this.planetaService.cadastrar(planeta)));
	}
	
	@DeleteMapping(path= "/{id}")
	public ResponseEntity<Response<Boolean>> remover(@PathVariable(name = "id")String id) {
		this.planetaService.remover(id);
		return ResponseEntity.ok(new Response<Boolean>(true)); 
	}
}
