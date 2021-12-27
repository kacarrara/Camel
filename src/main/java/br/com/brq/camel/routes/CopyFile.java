package br.com.brq.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CopyFile extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
	//detalha a origem e destino dos endpoint
     
	from("file:input")
	.to("file:output");
}
	
}