package br.com.sistemas.controleusuarioapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemas.controleusuarioapi.model.Usuario;
import br.com.sistemas.controleusuarioapi.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listarTodos() throws Exception {
		return ResponseEntity.ok(usuarioService.listarTodos());
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> consultarPorId(@PathVariable(name="id") Long id) throws Exception {

		if(id == null || id == 0) {
			return ResponseEntity.notFound().build();
		}
		
		Usuario usuario = usuarioService.consultarPorId(id);
		return ResponseEntity.ok(usuario);
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario u) throws Exception {

		if(!Optional.of(u).isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		
		if(u.getId() != null && u.getId() > 0) {
			return ResponseEntity.badRequest().build();
		}
		
		Usuario usuario = usuarioService.cadastrar(u);
		return ResponseEntity.ok(usuario);
	}
	
	@RequestMapping(value="/alterar", method=RequestMethod.PUT)
	public ResponseEntity<Usuario> alterar(@RequestBody Usuario u) throws Exception {

		if(!Optional.of(u).isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		
		if(u.getId() == null || u.getId() <= 0) {
			return ResponseEntity.badRequest().build();
		}
		
		Usuario usuario = usuarioService.alterar(u);
		return ResponseEntity.ok(usuario);
	}
	
	@RequestMapping(value="/excluir/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Usuario> excluir(@PathVariable(name="id") Long id) throws Exception {

		if(id == null || id == 0) {
			return ResponseEntity.notFound().build();
		}
		
		Usuario usuario = usuarioService.consultarPorId(id);
		if(!Optional.of(usuario).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		usuarioService.excluir(usuario);
		return ResponseEntity.ok(null);
	}

}
