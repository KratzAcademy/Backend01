package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	// Configurações de conexão
	private static final String URL = "jdbc:mysql://localhost:3306/jbdc_teste";
	private static final String USUARIO = "root";
	private static final String SENHA = "Aluno@123";

	public static void main(String[] args) {
		try {
			// Registrando o driver JDBC
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Estabelecendo a conexão com o banco de dados
			Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

			if (conexao != null) {
				System.out.println("Conexão estabelecida com sucesso!");
				// Menu principal
				Scanner scanner = new Scanner(System.in);
				int opcao;
				do {
					System.out.println("\n=== Menu ===");
					System.out.println("1. Cadastrar registro");
					System.out.println("2. Atualizar registro");
					System.out.println("3. Listar registros");
					System.out.println("4. Excluir registro");
					System.out.println("5. Sair");
					System.out.print("Escolha uma opção: ");
					opcao = scanner.nextInt();
					scanner.nextLine(); // Consumir a quebra de linha após o número
					switch (opcao) {
					case 1:
						cadastrarRegistro(conexao);
						break;
					case 2:
						atualizarRegistro(conexao);
						break;
					case 3:
						listarRegistros(conexao);
						break;
					case 4:
						excluirRegistro(conexao);
						break;
					case 5:
						System.out.println("Saindo do programa...");
						break;
					default:
						System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
					}

				} while (opcao != 5);
				scanner.close();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver JDBC não encontrado: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
		}
	}

	private static void cadastrarRegistro(Connection conexao) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o nome: ");
		String nome = scanner.nextLine();
		System.out.print("Digite a idade: ");
		int idade = scanner.nextInt();
		inserirRegistro(conexao, nome, idade);
	}

	private static void atualizarRegistro(Connection conexao) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o ID do registro a ser atualizado: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consumir a quebra de linha após o número
		System.out.print("Digite o novo nome: ");
		String novoNome = scanner.nextLine();
		System.out.print("Digite a nova idade: ");
		int novaIdade = scanner.nextInt();
		atualizarRegistro(conexao, id, novoNome, novaIdade);
	}

	private static void listarRegistros(Connection conexao) throws SQLException {
		selecionarRegistros(conexao);
	}

	private static void excluirRegistro(Connection conexao) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o ID do registro a ser excluído: ");
		int id = scanner.nextInt();
		apagarRegistro(conexao, id);
	}

	private static void inserirRegistro(Connection conexao, String nome, int idade) throws SQLException {
		String sql = "INSERT INTO tabela_exemplo (nome, idade) VALUES (?, ?)";
		try (PreparedStatement statement = conexao.prepareStatement(sql)) {
			statement.setString(1, nome);
			statement.setInt(2, idade);
			statement.executeUpdate();
			System.out.println("Registro inserido com sucesso.");
		}
	}

	private static void selecionarRegistros(Connection conexao) throws SQLException {
		String sql = "SELECT * FROM tabela_exemplo";
		try (PreparedStatement statement = conexao.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {
			System.out.println("Registros na tabela:");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				int idade = resultSet.getInt("idade");
				System.out.println("ID: " + id + ", Nome: " + nome + ", Idade: " + idade);
			}
		}
	}

	private static void atualizarRegistro(Connection conexao, int id, String novoNome, int novaIdade)
			throws SQLException {
		String sql = "UPDATE tabela_exemplo SET nome = ?, idade = ? WHERE id = ?";
		try (PreparedStatement statement = conexao.prepareStatement(sql)) {
			statement.setString(1, novoNome);
			statement.setInt(2, novaIdade);
			statement.setInt(3, id);
			int linhasAfetadas = statement.executeUpdate();
			if (linhasAfetadas > 0) {
				System.out.println("Registro atualizado com sucesso.");
			} else {
				System.out.println("Nenhum registro atualizado.");
			}
		}
	}

	private static void apagarRegistro(Connection conexao, int id) throws SQLException {
		String sql = "DELETE FROM tabela_exemplo WHERE id = ?";
		try (PreparedStatement statement = conexao.prepareStatement(sql)) {
			statement.setInt(1, id);
			int linhasAfetadas = statement.executeUpdate();
			if (linhasAfetadas > 0) {
				System.out.println("Registro apagado com sucesso.");
			} else {
				System.out.println("Nenhum registro apagado.");
			}
		}
	}
}
