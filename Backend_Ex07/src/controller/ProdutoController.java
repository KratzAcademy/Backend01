package controller;

import java.util.List;
import model.Produto;
import service.ProdutoService;

public class ProdutoController {

	public static boolean testarConexao() {
		return ProdutoService.testarConexao();
	}

	public static List<Produto> listarProdutos() {
		return ProdutoService.listarProdutos();
	}

	public static void inserirProduto(Produto produto) {
		ProdutoService.inserirProduto(produto);
	}

	public static void atualizarProduto(Produto produto) {
		ProdutoService.atualizarProduto(produto);
	}
	
	public static void excluirProduto(int id) {
        ProdutoService.excluirProduto(id);
    }
}
