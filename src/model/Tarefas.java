package model;

public class Tarefas implements java.io.Serializable {

	private static final long serialVersionUID = 1L;		

	private String titulo;
	private String descricao;
	private String fk_usuario_email;
	private int id;
	
	public Tarefas() {}

	public Tarefas(int id, String titulo, String descricao, String fk_usuario_email) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.fk_usuario_email = fk_usuario_email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFk_usuario_email() {
		return fk_usuario_email;
	}

	public void setFk_usuario_email(String fk_usuario_email) {
		this.fk_usuario_email = fk_usuario_email;
	}

}
