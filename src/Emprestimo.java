import java.sql.Date;

public class Emprestimo {
	private int idEmprestimo;
	private String dataEmpretismo;
	private String prazoEntrega;
	private Usuario usuario;
	private Livro livro;
	private String nomeLivro;
	private String nomeUsuario;
	
	
	
	
	// construrores
	public Emprestimo() {
		super();
		this.dataEmpretismo = dataEmpretismo;
		this.prazoEntrega = prazoEntrega;
		this.usuario = usuario;
		this.livro = livro;
	}
	
	// metodos de encapsulamento
	
	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsurio) {
		this.nomeUsuario = nomeUsurio;
	}

	
	public int getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public String getDataEmpretismo() {
		return dataEmpretismo;
	}
	
	
	public void setDataEmpretismo(String dataEmpretismo) {
		this.dataEmpretismo = dataEmpretismo;
	}
	public String getPrazoEntrega() {
		return prazoEntrega;
	}
	public void setPrazoEntrega(String prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public void registrarEmprestimo() {
		
	}
	
	public void removerEmprestimo() {
		
	}
	
	public void consultarEmprestimo() {
		
	}

}
