package br.spring.com.correiosapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.spring.com.correiosapi.error.ResourceNotFoundException;
import br.spring.com.correiosapi.model.Request;
import br.spring.com.correiosapi.model.Response;
import br.spring.com.correiosapi.util.CalculaFrete;

@CrossOrigin
@RestController
@RequestMapping("correios")
public class Controller {

	@PostMapping(path = "frete")
	public ResponseEntity<?> Frete(@RequestBody Request request) {
		Response response = CalculaFrete.calculaFrete(request);

		if(response == null) throw new ResourceNotFoundException("Invalid Request");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
