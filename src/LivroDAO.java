import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Livro Livro) {

		// Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		// de dados

		String sql = "INSERT INTO livro(nomeLivro,autor,statu,editora)" + " VALUES(?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = ConexaoBD.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, Livro.getEditora());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, Livro.getAutor());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setBoolean(3, Livro.getStatus());
			
			pstm.setString(4, Livro.getEditora());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	public void removeBYId(int id) {
		String sql = "DELETE FROM Livro WHERE id = ?";

		try {
			conn = ConexaoBD.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
	
	
	public Livro searchBYId(int id) {
		ResultSet rset = null;
		Livro livro = new Livro();
		String sql = "SELECT *FROM Livro WHERE id = ?";

		try {
			conn = ConexaoBD.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {

				

				// Recupera o id do banco e atribui ele ao objeto
				livro.setIdLivro(rset.getInt("id"));               

				// Recupera o nome do banco e atribui ele ao objeto
				livro.setNomeLivro(rset.getString("nomeLivro"));

				// Recupera a idade do banco e atribui ele ao objeto
				livro.setAutor(rset.getString("autor"));

				// Recupera a data do banco e atribui ela ao objeto
				livro.setStatus(rset.getBoolean("statu"));
				
				livro.setEditora(rset.getString("editora"));
				

				
			}

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return livro;
	}

	public void update(Livro livro) {
		String sql = "UPDATE Livro SET nomeLivro = ?, autor = ?, statu = ?, editora = ? " + "WHERE id = ?";
		try {

			conn = ConexaoBD.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, livro.getNomeLivro());
			pstm.setString(2, livro.getAutor());
			pstm.setBoolean(3, livro.getStatus());
			pstm.setString(4, livro.getEditora());
			
			pstm.setInt(5, livro.getIdLivro());
			

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	public List<Livro> getLivros() {

		String sql = "SELECT * FROM livro";

		List<Livro> livros = new ArrayList<Livro>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConexaoBD.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Livro livro = new Livro();

				// Recupera o id do banco e atribui ele ao objeto
				livro.setIdLivro(rset.getInt("id"));

				// Recupera o nome do banco e atribui ele ao objeto
				livro.setNomeLivro(rset.getString("nomeLivro"));

				// Recupera a idade do banco e atribui ele ao objeto
				livro.setAutor(rset.getString("autor"));

				// Recupera a data do banco e atribui ela ao objeto
				livro.setStatus(rset.getBoolean("statu"));

				// Adiciono o Livro recuperado, a lista de Livros
				livros.add(livro);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return livros;
	}

}

