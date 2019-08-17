package br.com.sistemas.controleusuarioapi.service;

import java.util.List;
import java.util.Optional;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemas.controleusuarioapi.dao.UsuarioDAO;
import br.com.sistemas.controleusuarioapi.model.Usuario;

@Service
public class UsuarioService implements GenericoService<Usuario> {

	@Autowired(required=true)
	private UsuarioDAO usuarioDao;
	
	@Override
	public Usuario consultarPorId(Long id) throws Exception {
		
		if(id == null) throw new ValidationException("O parametro id é requerido!");
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	public List<Usuario> listarTodos() throws Exception {
		
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public Usuario cadastrar(Usuario u) throws Exception {
		
		if(!Optional.of(u).isPresent()) throw new ValidationException("O parametro usuario é requerido!");
		return usuarioDao.save(u);
	}

	@Override
	public Usuario alterar(Usuario u) throws Exception {

		if(!Optional.of(u).isPresent()) throw new ValidationException("O parametro usuario é requerido!");

		if(u.getId() == null) throw new ValidationException("O parametro usuario não possuí ID válido!");
		
		return usuarioDao.save(u);
	}

	@Override
	public void excluir(Usuario u) throws Exception {

		if(!Optional.of(u).isPresent()) throw new ValidationException("O parametro usuario é requerido!");

		if(u.getId() == null) throw new ValidationException("O parametro usuario não possuí ID válido!");
		
		usuarioDao.delete(u);
		
	}
	

}
