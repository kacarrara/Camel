package br.com.brq.camel.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.brq.camel.domain.PetEntity;
import br.com.brq.camel.services.PetService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PetProcessor implements Processor {
	
	private PetService petService;
	
	public PetProcessor (PetService petService) {
		this.petService = petService;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		String petStr = exchange.getIn().getBody(String.class);
		
		//System.out.println("sout " + petStr);
		log.info("sout " + petStr);
		
		ObjectMapper object = new ObjectMapper();
		PetEntity pet = object.readValue(petStr, PetEntity.class);
		//System.out.println( pet);
		log.info(pet.toString());
		
		this.petService.save(pet);
	}

}
