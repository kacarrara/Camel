package br.com.brq.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.brq.camel.processors.PetProcessor;
import br.com.brq.camel.services.PetService;

@Component
public class PetPolling extends RouteBuilder{
	
	@Autowired
	private PetService petService;
	
	@Override
	public void configure() throws Exception {
		
		from("timer:pet?period=2000")
			.setHeader("id", simple("${random(1,4)}"))
			.to("rest:get:pets/{id}?host=http://localhost:8080")
				.process(new PetProcessor())
					.log("${body}");
	}	
}
