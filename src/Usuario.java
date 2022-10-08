
public class Usuario {

	private int matricula;
	private String email;
	private String pendecias;
	private String senha;
	private String nomeUsuario;
	
	//construtores
	public Usuario(int matricula, String email, String pendecias, String senha, String nomeUsuario) {
		super();
		this.matricula = matricula;
		this.email = email;
		this.pendecias = pendecias;
		this.senha = senha;
		this.nomeUsuario = nomeUsuario;
	}
	Usuario() {
		

	}
	
	
	// metodos de encapsulamento
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public int getMatricula() {
		return matricula;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPendecias() {
		return pendecias;
	}
	public void setPendecias(String pendecias) {
		this.pendecias = pendecias;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
}
