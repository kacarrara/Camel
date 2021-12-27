package br.com.brq.camel.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brq.camel.domain.PetEntity;

@RestController
@RequestMapping(value = "pets")
public class PetController {
	
	// o id do PET deve ser de 1 a 3
	private static final String[] PETS = 
			new String[] {"Floquinho", "Bolinha", "Tulipa"};
	
//	@GetMapping(value = "{id}")
//	public Map<String, String> getById(@PathVariable int id) {
//		
//		if (id > 0 && id <= PETS.length) {
//			String nomePet = PETS[id - 1];
//			return Collections.singletonMap("nome", nomePet);
//		}
//		else {
//			return Collections.emptyMap();
//		}
////		{STRING,STRING}
////		{nome : "Floquinho"}
//	}
	@GetMapping(value = "{id}")
	public PetEntity getById(@PathVariable int id) {
		
		if (id > 0 && id <= PETS.length) {
			String nomePet = PETS[id - 1];
			return PetEntity.builder().id(id).nome(nomePet).build();
		}
		else {
			return PetEntity.builder().build();
		}
	}
}