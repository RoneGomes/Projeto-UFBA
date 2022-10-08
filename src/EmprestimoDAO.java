import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Emprestimo emprestimo) {

		// Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		// de dados

		String sql = "INSERT INTO emprestimo(nomeUsuario,dataEmprestimo,prazoEntrega,nomeLivro)" + " VALUES(?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = ConexaoBD.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, emprestimo.getNomeUsuario());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, emprestimo.getDataEmpretismo());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, emprestimo.getPrazoEntrega());
			
			pstm.setString(4, emprestimo.getNomeLivro());
			

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
		String sql = "DELETE FROM emprestimo WHERE id = ?";

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

	public Emprestimo searchBYId(int id) {
		ResultSet rset = null;
		Emprestimo emprestimo = new Emprestimo();
		
		String sql = "SELECT *FROM emprestimo WHERE id = ?";

		try {
			conn = ConexaoBD.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			while (rset.next()) {

				// Recupera o id do banco e atribui ele ao objeto
				emprestimo.setNomeUsuario(rset.getString("nomeUsuario"));

				// Recupera o nome do banco e atribui ele ao objeto
				emprestimo.setDataEmpretismo(rset.getString("dataEmprestimo"));

				// Recupera a idade do banco e atribui ele ao objeto
				emprestimo.setPrazoEntrega(rset.getString("prazoEntrega"));

				// Recupera a data do banco e atribui ela ao objeto
				emprestimo.setNomeLivro(rset.getString("nomeLivro"));
				

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
		return emprestimo;
	}

	public void update(Emprestimo emprestimo) {
		String sql = "UPDATE emprestimo SET nomeUsuario = ?, dataEmprestimo = ?, prazoEntrega = ?, nomeLivro= ? " + "WHERE id = ?";
		try {

			conn = ConexaoBD.createConnectionToMySQL();

	
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, emprestimo.getNomeUsuario());
			pstm.setString(2, emprestimo.getDataEmpretismo());
			pstm.setString(3, emprestimo.getPrazoEntrega());
			pstm.setString(4, emprestimo.getNomeLivro());
			pstm.setInt(5, emprestimo.getIdEmprestimo());

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

	public List<Emprestimo> getEmprestimos() {

		String sql = "SELECT * FROM emprestimo";

		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConexaoBD.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Emprestimo emprestimo = new Emprestimo();

				// Recupera o id do banco e atribui ele ao objeto
				emprestimo.setIdEmprestimo(rset.getInt("id"));

				// Recupera o nome do banco e atribui ele ao objeto
				emprestimo.setDataEmpretismo(rset.getString("dataEmprestimo"));

				// Recupera a idade do banco e atribui ele ao objeto
				emprestimo.setPrazoEntrega(rset.getString("prazoEntrega"));

				// Recupera a data do banco e atribui ela ao objeto
				emprestimo.setNomeLivro(rset.getString("nomeLivro"));

				// Adiciono o emprestimo recuperado, a lista de emprestimos
				emprestimos.add(emprestimo);
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

		return emprestimos;
	}

}
