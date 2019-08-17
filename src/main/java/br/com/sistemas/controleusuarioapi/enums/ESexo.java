package br.com.sistemas.controleusuarioapi.enums;

public enum ESexo {
	
	M("Masculino"),
	F("Feminino");
	
	private String descricao;
	
	ESexo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
