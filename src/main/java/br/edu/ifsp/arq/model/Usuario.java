package br.edu.ifsp.arq.model;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public String Usuario;
	private String Senha;
	private static int proximo_id = 0;
	private int id;
	
	public Usuario() {
		this.id = ++proximo_id;
	}
	
	public Usuario(String Usuario, String Senha) {
		this();
		this.Usuario = Usuario;
		this.Senha = Senha;
	}
	
	public int getId() {
		return this.id;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}
	
	

}
