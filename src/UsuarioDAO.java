import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Usuario usuario) {

		// Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		// de dados

		String sql = "INSERT INTO usuario(nomeUsuario,email,senha,pendencias)" + " VALUES(?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = ConexaoBD.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, usuario.getNomeUsuario());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, usuario.getEmail());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, usuario.getSenha());
			
			pstm.setString(4, usuario.getPendecias());
			

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
		String sql = "DELETE FROM usuario WHERE matricula = ?";

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

	public Usuario searchBYId(int id) {
		ResultSet rset = null;
		Usuario usuario = new Usuario();
		
		String sql = "SELECT *FROM usuario WHERE matricula = ?";

		try {
			conn = ConexaoBD.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			while (rset.next()) {

				// Recupera o id do banco e atribui ele ao objeto
				usuario.setMatricula(rset.getInt("matricula"));

				// Recupera o nome do banco e atribui ele ao objeto
				usuario.setNomeUsuario(rset.getString("nomeUsuario"));

				// Recupera a idade do banco e atribui ele ao objeto
				usuario.setEmail(rset.getString("idade"));

				// Recupera a data do banco e atribui ela ao objeto
				usuario.setSenha(rset.getString("senha"));
				
				usuario.setPendecias(rset.getString("pendencias"));

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
		return usuario;
	}

	public void update(Usuario usuario) {
		String sql = "UPDATE usuario SET nomeUsuario = ?, email = ?, senha = ?, pendencias = ? " + "WHERE matricula = ?";
		try {

			conn = ConexaoBD.createConnectionToMySQL();

	
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario.getNomeUsuario());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getSenha());
			pstm.setString(4, usuario.getPendecias());
			pstm.setInt(5, usuario.getMatricula());

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

	public List<Usuario> getUsuarios() {

		String sql = "SELECT * FROM usuario";

		List<Usuario> usuarios = new ArrayList<Usuario>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConexaoBD.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Usuario usuario = new Usuario();

				// Recupera o id do banco e atribui ele ao objeto
				usuario.setMatricula(rset.getInt("matricula"));

				// Recupera o nome do banco e atribui ele ao objeto
				usuario.setNomeUsuario(rset.getString("nomeUsuario"));

				// Recupera a idade do banco e atribui ele ao objeto
				usuario.setEmail(rset.getString("email"));

				// Recupera a data do banco e atribui ela ao objeto
				usuario.setSenha(rset.getString("senha"));
				
				usuario.setPendecias(rset.getString("pendencias"));

				// Adiciono o usuario recuperado, a lista de usuarios
				usuarios.add(usuario);
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

		return usuarios;
	}

}
