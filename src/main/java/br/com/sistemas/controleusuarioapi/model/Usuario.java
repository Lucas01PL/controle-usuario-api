package br.com.sistemas.controleusuarioapi.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import br.com.sistemas.controleusuarioapi.enums.ESexo;

@Data
@Entity
@Table(name="usuario", catalog="postgres")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = -8702931314532022114L;

	@Id
	@GeneratedValue(generator="sequence_usuario", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="sequence_usuario", sequenceName="usuario_id_seq", initialValue=1, catalog="postgres", schema="administrativo", allocationSize=1)
	private Long id;
	private String nome;
	private String cpf;
	
	@Column(name="data_nascimento")
	private LocalDate dataNascimento;

	@Enumerated(EnumType.STRING)
	@Column(name="genero")
	private ESexo sexo;
	
	@ManyToOne
	@JoinColumn(name="funcao_id")
	private Funcao funcao;
	
	@ManyToMany
	@JoinTable(
		name="usuario_papel",
		joinColumns = @JoinColumn(name = "usuario_id"), 
		inverseJoinColumns = @JoinColumn(name = "papel_id")
	)
	private List<Papel> papeis;
	
}
