package br.com.sistemas.controleusuarioapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemas.controleusuarioapi.model.Funcao;

@Repository
public interface FuncaoDAO extends CrudRepository<Funcao, Long>{

}
