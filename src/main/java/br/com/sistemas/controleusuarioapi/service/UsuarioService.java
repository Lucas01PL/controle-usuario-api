package br.com.sistemas.controleusuarioapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;
import br.com.sistemas.controleusuarioapi.dao.UsuarioDAO;
import br.com.sistemas.controleusuarioapi.exception.ModelException;
import br.com.sistemas.controleusuarioapi.model.Usuario;

@Service
public class UsuarioService implements GenericoService<Usuario> {

	@Autowired(required=true)
	private UsuarioDAO usuarioDao;
	
	@Override
	public Usuario consultarPorId(Long id) throws Exception {
		
		if(id == null) throw new ModelException("O parametro id é requerido!");
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	public List<Usuario> listarTodos() throws Exception {
		
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public Usuario cadastrar(Usuario u) throws Exception {
		
		validarCamposCadastroOuAlteracao(u);
		return usuarioDao.save(u);
	}

	@Override
	public Usuario alterar(Usuario u) throws Exception {

		validarCamposCadastroOuAlteracao(u);

		if(u.getId() == null) throw new ModelException("O parametro usuario não possuí ID válido!");
		
		return usuarioDao.save(u);
	}

	@Override
	public void excluir(Usuario u) throws Exception {

		if(!Optional.of(u).isPresent()) throw new ModelException("O parametro usuario é requerido!");

		if(u.getId() == null) throw new ModelException("O parametro usuario não possuí ID válido!");
		
		usuarioDao.delete(u);
		
	}
	
	public void validarCamposCadastroOuAlteracao(Usuario usuario) throws Exception {
		
		if(!Optional.of(usuario).isPresent()) throw new ModelException("O parametro usuario é requerido!");
		
		if(StringUtils.isEmpty(usuario.getNome())) throw new ModelException("O parametro nome do usuario é requerido!");
		
		if(StringUtils.isEmpty(usuario.getCpf())) throw new ModelException("O parametro CPF do usuario é requerido!");
		
		if(!Optional.of(usuario.getFuncao()).isPresent()) throw new ModelException("O parametro função do usuario é requerido!");
		
		if(usuario.getFuncao().getId() == null || usuario.getFuncao().getId() == 0) throw new ModelException("O parametro função do usuario é requerido!");
		
		if(usuario.getSexo() == null) throw new ModelException("O parametro sexo do usuario é requerido!");
	}

}
