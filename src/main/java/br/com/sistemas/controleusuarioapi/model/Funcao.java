package br.com.sistemas.controleusuarioapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="funcao", catalog="postgres")
public class Funcao implements Serializable {

	private static final long serialVersionUID = -9047353026604145216L;
	
	@Id
	@GeneratedValue(generator="sequence_funcao", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="sequence_funcao", sequenceName="sequence_funcao", initialValue=1, catalog="controle_usuario", schema="administrativo")
	private Long id;
	private String nome;
	
	/*
	@OneToMany
	private List<Papel> papeis;
	*/

}
