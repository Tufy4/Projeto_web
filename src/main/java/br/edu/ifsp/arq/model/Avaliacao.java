package br.edu.ifsp.arq.model;

public class Avaliacao {
	private int id;
	private int  receitaId;
	private String nomeAvaliador;
	private String comentario;
	private int nota;

	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReceitaId() {
		return receitaId;
	}
	public void setReceitaId(int receitaId) {
		this.receitaId = receitaId;
	}
	public String getNomeAvaliador() {
		return nomeAvaliador;
	}
	public void setNomeAvaliador(String nomeAvaliador) {
		this.nomeAvaliador = nomeAvaliador;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	
	
}
