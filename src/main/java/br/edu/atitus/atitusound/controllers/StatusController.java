package br.edu.atitus.atitusound.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("status")
public class StatusController {

	@GetMapping({"", "/aplicacao"})
	public String getStatus() {
		return "Aplicação está no Ar!";
	}
	
	@PostMapping
	public ResponseEntity<String> postStatus(@RequestBody(required = false) String textoEntrada) {
		return ResponseEntity.status(HttpStatus.CREATED).body("Texto recebido: " + textoEntrada) ;
	}
	
	
}



