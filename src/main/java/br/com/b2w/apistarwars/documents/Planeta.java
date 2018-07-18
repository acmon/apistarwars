package br.com.b2w.apistarwars.documents;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Planeta {

	@Id
	private String id;
	private String nome;
	private String clima;
	private String terreno;
	
	public Planeta() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@NotEmpty(message = "O nome não foi informado")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotEmpty(message = "O clima não foi informado")
	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}
	
	@NotEmpty(message = "O terreno não foi informado")
	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	
}
