import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		Livro livro = new Livro();
		LivroDAO livroDao = new LivroDAO();
		Emprestimo emprestimo = new Emprestimo();
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

		
		Scanner receba = new Scanner(System.in);
		int opcao, id;

		do {
			System.out.println("=========Sistema Biblioteca ==========");
			System.out.println("1- Cadastro Usuario");
			System.out.println("2- Cadastrar Livro");
			System.out.println("3- Fazer um Emprestimo");
			System.out.println("4- Editar Usuario");
			System.out.println("5- Editar Livro ");
			System.out.println("6- Consultar Livros");
			System.out.println("7- Consultar Emprestimo");
			System.out.println("8- Sair");

			opcao = receba.nextInt();

			switch (opcao) {
			case 1: {

				System.out.println("Digite o nome do usuario que deseja cadastrar");
				usuario.setNomeUsuario(receba.next());

				System.out.println("Digite o email que deseja cadastrar");
				usuario.setEmail(receba.next());

				System.out.println("Digite a senha do usuario que deseja cadastrar");
				usuario.setSenha(receba.next());

				usuarioDAO.save(usuario);
				System.out.println("usuario cadastrado");

				break;
			}
			case 2: {

				System.out.println("Digite o nome livro que deseja cadastrar");
				livro.setNomeLivro(receba.next());

				System.out.println("Digite o nome do Autor");
				livro.setAutor(receba.next());

				System.out.println("Digite o nome da editora");
				livro.setEditora(receba.next());

				livro.setStatus(false);

				livroDao.save(livro);

				System.out.println("livro cadastrado");

				break;
			}

			case 3: {

				System.out.println("Digite o id do livro que deseja pegar emprestado");
				id = receba.nextInt();
				livro = livroDao.searchBYId(id);
				if (id == livro.getIdLivro()) {
					if (livro.getStatus() == false) {
						System.out.println("Digite nome do livro");
						emprestimo.setNomeLivro(receba.next());

						System.out.println("Digite data incial");
						emprestimo.setDataEmpretismo(receba.next());

						System.out.println("Digite de entrega");
						emprestimo.setPrazoEntrega(receba.next());

						System.out.println("Digite o nome do usuario");
						emprestimo.setNomeUsuario(receba.next());
						
						emprestimoDAO.save(emprestimo);

						System.out.println("emprestimo realizado com sucesso !");
						livro.setStatus(true);

					} else {
						System.out.println("livro não disponivel para emprestimo ");
					}

				} else {

					System.out.println("livro não cadastrado , por favor reveja o identificador do livro ");

				}

				

				break;
			}
			case 4: {
				System.out.println("Digite a matricula do usuario que para atuaizar");
				usuario.setMatricula(receba.nextInt());

				System.out.println("Digite o no do usuario que deseja atuaizar");
				usuario.setNomeUsuario(receba.next());

				System.out.println("Digite um novo email para atualizar");
				usuario.setEmail(receba.next());
				
				System.out.println("Digite as pendencias do usuario");
				usuario.setPendecias(receba.next());
				
				System.out.println("Digite a nova senha ");
				usuario.setSenha(receba.next());

				usuarioDAO.update(usuario);

				System.out.println("usuario atualizado");
				break;
				

			}
			case 5: {
				
				System.out.println("Digite o identificador do livro");
				livro.setIdLivro(receba.nextInt());
				
				System.out.println("Digite o nome livro que deseja cadastrar");
				livro.setNomeLivro(receba.next());

				System.out.println("Digite o nome do Autor");
				livro.setAutor(receba.next());

				System.out.println("Digite o nome da editora");
				livro.setEditora(receba.next());


				livroDao.update(livro);
		

				System.out.println("livro atualizado");
				break;

			}
			case 6: {

				for (Livro l : livroDao.getLivros()) {

					System.out.println("Id: " + l.getIdLivro());
					
					System.out.println("Livro: " + l.getIdLivro());

					System.out.println("Autor " + l.getAutor());

					System.out.println("Editora: " + l.getEditora());
					
					System.out.println("Status: " + l.getStatus());

					System.out.println("--------------------------------------------");

				}

				break;

			}

			case 7: {

				for (Emprestimo e : emprestimoDAO.getEmprestimos()) {
					System.out.println("Id: " + e.getIdEmprestimo());

					System.out.println("Nome do livro : " + e.getNomeLivro());

					System.out.println("Nome do livro " + e.getNomeLivro());

					System.out.println("Data do emprestimo: " + e.getDataEmpretismo());
					
					System.out.println("Data de entrega: " + e.getPrazoEntrega());

					System.out.println("--------------------------------------------");

				}

				break;

			}

			case 8: {
				System.out.println("obrigado por usar nossa agenda!");
				break;
			}

			default:
				System.out.println("opcao inexistente por favor degite novamente");
			}

		} while (opcao != 8);

		receba.close();

	}

}
