package br.com.sistemas.controleusuarioapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemas.controleusuarioapi.model.Usuario;

@Repository
public interface UsuarioDAO extends CrudRepository<Usuario, Long>{

}
