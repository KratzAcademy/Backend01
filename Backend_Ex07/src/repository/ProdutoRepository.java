package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoRepository {
	private static final String URL = "jdbc:mysql://localhost:3306/db_crud";
	private static final String USER = "root";
	private static final String PASSWORD = "Aluno@123";

	public static boolean testarConexao() {
		try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD)) {
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean inserirProduto(Produto produto) {
		String sql = "INSERT INTO produtos (nome, quantidade, valor, data, status) VALUES (?, ?, ?, ?, ?)";
		try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement statement = conexao.prepareStatement(sql)) {
			statement.setString(1, produto.getNome());
			statement.setInt(2, produto.getQuantidade());
			statement.setDouble(3, produto.getValor());
			statement.setDate(4, new java.sql.Date(produto.getData().getTime()));
			statement.setString(5, produto.getStatus());
			int linhasAfetadas = statement.executeUpdate();
			return linhasAfetadas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean atualizarProduto(Produto produto) {
		String sql = "UPDATE produtos SET nome = ?, quantidade = ?, valor = ?, data = ?, status = ? WHERE id = ?";
		try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement statement = conexao.prepareStatement(sql)) {
			statement.setString(1, produto.getNome());
			statement.setInt(2, produto.getQuantidade());
			statement.setDouble(3, produto.getValor());
			statement.setDate(4, new java.sql.Date(produto.getData().getTime()));
			statement.setString(5, produto.getStatus());
			statement.setInt(6, produto.getId());
			int linhasAfetadas = statement.executeUpdate();
			return linhasAfetadas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean excluirProduto(int id) {
		String sql = "DELETE FROM produtos WHERE id = ?";
		try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement statement = conexao.prepareStatement(sql)) {
			statement.setInt(1, id);
			int linhasAfetadas = statement.executeUpdate();
			return linhasAfetadas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static List<Produto> selecionarTodosProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = conexao.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(resultSet.getInt("id"));
                produto.setNome(resultSet.getString("nome"));
                produto.setQuantidade(resultSet.getInt("quantidade"));
                produto.setValor(resultSet.getDouble("valor"));
                produto.setData(resultSet.getDate("data"));
                produto.setStatus(resultSet.getString("status"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }
}
