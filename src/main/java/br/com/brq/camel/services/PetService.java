package br.com.brq.camel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.camel.domain.PetEntity;
import br.com.brq.camel.repositories.PetRepository;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;
	
	public PetEntity save( PetEntity pet) {
		return this.petRepository.save(pet);
	}
}
