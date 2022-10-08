
public class Livro {
	private int idLivro;
	private String nomeLivro;
	private String autor;
	private boolean status;
	private String editora;
	
	
	
	public Livro(int idLivro, String nomeLivro, String autor, String editora,boolean status) {
		super();
		this.idLivro = idLivro;
		this.nomeLivro = nomeLivro;
		this.autor = autor;
		this.editora = editora;
		this.status= status;
	}
	
	public Livro() {
		
	}
	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	public int getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public void cadastrarLivro() {
		
	}
	
	/*public Livro consultarLivro() {
		return;	
	}*/
	public void EditarLivro() {
		
	}
	public void removerLivro() {
		
	}
	

}
