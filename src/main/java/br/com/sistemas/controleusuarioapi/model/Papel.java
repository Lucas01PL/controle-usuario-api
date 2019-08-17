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
@Table(name="papel", catalog="postgres")
public class Papel implements Serializable {

	private static final long serialVersionUID = -6824797812194619702L;
	
	@Id
	@GeneratedValue(generator="sequence_papel", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="sequence_papel", sequenceName="sequence_papel", initialValue=1, catalog="controle_usuario", schema="administrativo")
	private Long id;
	private String descricao;

}
