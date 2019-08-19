package br.com.sistemas.controleusuarioapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemas.controleusuarioapi.model.Funcao;
import br.com.sistemas.controleusuarioapi.service.FuncaoService;

@RestController
@RequestMapping("/funcao")
@CrossOrigin(origins = "http://localhost:4200")
public class FuncaoController {
	
	@Autowired
	FuncaoService funcaoService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<List<Funcao>> listarTodas() throws Exception {
		try {
			List<Funcao> funcoes = funcaoService.listarTodos();
			return ResponseEntity.ok(funcoes);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Funcao> consultarPorId(@PathVariable(name="id") String id) throws Exception {

		try {
			if(id == null || id.isEmpty()) 
				return ResponseEntity.badRequest().build();
			
			Funcao funcao = funcaoService.consultarPorId(new Long(id));
			if(!Optional.of(funcao).isPresent()) 
				return ResponseEntity.notFound().build();
			
			return ResponseEntity.ok(funcao);	
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
	}
}
