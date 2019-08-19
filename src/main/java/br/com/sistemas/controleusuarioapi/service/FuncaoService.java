package br.com.sistemas.controleusuarioapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemas.controleusuarioapi.dao.FuncaoDAO;
import br.com.sistemas.controleusuarioapi.exception.ModelException;
import br.com.sistemas.controleusuarioapi.model.Funcao;

@Service
public class FuncaoService implements GenericoService<Funcao> {

	@Autowired
	FuncaoDAO funcaoDao;
	
	@Override
	public Funcao consultarPorId(Long id) throws Exception {
		if(id == null) throw new ModelException("O parametro id é requerido!");
		return funcaoDao.findById(id).orElse(null);
	}

	@Override
	public List<Funcao> listarTodos() throws Exception {
		return (List<Funcao>) funcaoDao.findAll();
	}

	@Override
	public Funcao cadastrar(Funcao e) throws Exception {
		return null;
	}

	@Override
	public Funcao alterar(Funcao e) throws Exception {
		return null;
	}

	@Override
	public void excluir(Funcao e) throws Exception {
	}

}
