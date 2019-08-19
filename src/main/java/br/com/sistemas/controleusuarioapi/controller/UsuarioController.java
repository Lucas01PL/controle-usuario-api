package br.com.sistemas.controleusuarioapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemas.controleusuarioapi.model.Usuario;
import br.com.sistemas.controleusuarioapi.service.FuncaoService;
import br.com.sistemas.controleusuarioapi.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	FuncaoService funcaoService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listarTodos() throws Exception {
		try {
			List<Usuario> usuarios = usuarioService.listarTodos();
			return ResponseEntity.ok(usuarios);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> consultarPorId(@PathVariable(name="id") String id) throws Exception {

		try {
			if(id == null || id.isEmpty()) 
				return ResponseEntity.badRequest().build();
			
			Usuario usuario = usuarioService.consultarPorId(new Long(id));
			if(!Optional.of(usuario).isPresent()) 
				return ResponseEntity.notFound().build();
			
			return ResponseEntity.ok(usuario);	
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario u) throws Exception {

		try {
			if(!Optional.of(u).isPresent()) {
				return ResponseEntity.badRequest().build();
			}
			
			if(u.getId() != null && u.getId() > 0) {
				return ResponseEntity.badRequest().build();
			}
			
			Usuario usuario = usuarioService.cadastrar(u);
			usuario.setFuncao(funcaoService.consultarPorId(usuario.getFuncao().getId()));
			return ResponseEntity.ok(usuario);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
	}
	
	@RequestMapping(value="/alterar", method=RequestMethod.PUT)
	public ResponseEntity<Usuario> alterar(@RequestBody Usuario u) throws Exception {

		try {
			if(!Optional.of(u).isPresent()) {
				return ResponseEntity.badRequest().build();
			}
			
			if(u.getId() == null || u.getId() <= 0) {
				return ResponseEntity.badRequest().build();
			}
			
			Usuario usuario = usuarioService.alterar(u);
			usuario.setFuncao(funcaoService.consultarPorId(usuario.getFuncao().getId()));
			return ResponseEntity.ok(usuario);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
	}
	
	@RequestMapping(value="/excluir/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Usuario> excluir(@PathVariable(name="id") Long id) throws Exception {

		try {
			if(id == null || id == 0) {
				return ResponseEntity.notFound().build();
			}
			
			Usuario usuario = usuarioService.consultarPorId(id);
			if(!Optional.of(usuario).isPresent()) {
				return ResponseEntity.notFound().build();
			}
	
			usuarioService.excluir(usuario);
			return ResponseEntity.ok(null);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
	}

}
