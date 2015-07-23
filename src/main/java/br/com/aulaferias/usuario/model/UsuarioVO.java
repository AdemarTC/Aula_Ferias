package br.com.aulaferias.usuario.model;

public class UsuarioVO {
	
	private Integer sequencial;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	
	
	public Integer getSequencial() {
		return sequencial;
	}
	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
