package conexao;

public class Livro {
	private long idLivro;
	private String titulo;
	private String autor;
	private String categoria;
	private float valor;
	
	public Livro() {
		// TODO Auto-generated constructor stub
	}
	
	public long getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(long idLivro) {
		this.idLivro = idLivro;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float d) {
		this.valor = d;
	}
		
}

