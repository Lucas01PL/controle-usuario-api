package br.com.sistemas.controleusuarioapi.service;

import java.util.List;

public interface GenericoService<E> {
	
	E consultarPorId(Long id) throws Exception;
	
	List<E> listarTodos() throws Exception;
	
	E cadastrar(E e) throws Exception;
	
	E alterar (E e) throws Exception;
	
	void excluir(E e) throws Exception;

}
