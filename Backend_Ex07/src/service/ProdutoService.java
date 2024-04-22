package service;

import java.util.List;
import model.Produto;
import repository.ProdutoRepository;

public class ProdutoService {

	private static final ProdutoRepository repository = new ProdutoRepository();

	public static boolean testarConexao() {
		return ProdutoRepository.testarConexao();
	}

	public static List<Produto> listarProdutos() {
        return repository.selecionarTodosProdutos();
    }
	
	public static void atualizarProduto(Produto produto) throws IllegalArgumentException {
        validarProduto(produto);
        repository.atualizarProduto(produto);
    }
	
	public static void excluirProduto(int id) {
        repository.excluirProduto(id);
    }
	
	public static void inserirProduto(Produto produto) throws IllegalArgumentException {
		validarProduto(produto);
		repository.inserirProduto(produto);
	}

	private static void validarProduto(Produto produto) throws IllegalArgumentException {
		if (produto.getNome() == null || produto.getNome().isEmpty()) {
			throw new IllegalArgumentException("O nome do produto não pode estar em branco.");
		}
		if (produto.getQuantidade() <= 0) {
			throw new IllegalArgumentException("A quantidade do produto deve ser maior que zero.");
		}
		if (produto.getValor() <= 0) {
			throw new IllegalArgumentException("O valor do produto deve ser maior que zero.");
		}
		// Outras validações podem ser adicionadas conforme necessário
	}
}
