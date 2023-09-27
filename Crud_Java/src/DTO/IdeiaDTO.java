package DTO;

public class IdeiaDTO {
	
	
	private String titulo_ideia, descricao_ideia, urgencia_ideia;
	private int id_ideia;
	
	
	// GET E SET
	
	
	
	public int getId_ideia() {
		return id_ideia;
	}
	public void setId_ideia(int id_ideia) {
		this.id_ideia = id_ideia;
	}
	public String getTitulo_ideia() {
		return titulo_ideia;
	}
	public void setTitulo_ideia(String titulo_ideia) {
		this.titulo_ideia = titulo_ideia;
	}
	public String getDescricao_ideia() {
		return descricao_ideia;
	}
	public void setDescricao_ideia(String descricao_ideia) {
		this.descricao_ideia = descricao_ideia;
	}
	public String getUrgencia_ideia() {
		return urgencia_ideia;
	}
	public void setUrgencia_ideia(String urgencia_ideia) {
		this.urgencia_ideia = urgencia_ideia;
	}
	
	
}
