package view;

import java.util.List;
import java.util.Scanner;
import controller.ProdutoController;
import model.Produto;

public class ProdutoView {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcao;

		do {
			System.out.println("\n=== Menu ===");
			System.out.println("1. Listar Produtos");
			System.out.println("2. Inserir Produto");
			System.out.println("3. Atualizar Produto");
			System.out.println("4. Excluir Produto");
			System.out.println("5. Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine(); // Consumir a quebra de linha após o número

			switch (opcao) {
			case 1:
				listarProdutos();
				break;
			case 2:
				inserirProduto();
				break;
			case 3:
				atualizarProduto();
				break;
			case 4:
				excluirProduto();
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

	private static void listarProdutos() {
	    List<Produto> produtos = ProdutoController.listarProdutos();
	    if (produtos.isEmpty()) {
	        System.out.println("Não há produtos cadastrados.");
	    } else {
	    	System.out.println("=================================");
	        System.out.println("=      Lista de Produtos        =");
	        System.out.println("=================================");
	        for (Produto produto : produtos) {
	            System.out.println("ID: " + produto.getId());
	            System.out.println("Nome: " + produto.getNome());
	            System.out.println("Quantidade: " + produto.getQuantidade());
	            System.out.println("Valor: " + produto.getValor());
	            System.out.println("Data: " + produto.getData());
	            System.out.println("Status: " + produto.getStatus());
	            System.out.println("=================================");
	            System.out.println();
	        }
	    }
	}

	private static void inserirProduto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o nome do produto: ");
		String nome = scanner.nextLine();
		System.out.print("Digite a quantidade do produto: ");
		int quantidade = scanner.nextInt();
		System.out.print("Digite o valor do produto: ");
		double valor = scanner.nextDouble();
		scanner.nextLine(); // Consumir a quebra de linha após o número
		System.out.print("Digite a data do produto (formato: yyyy-MM-dd): ");
		String dataStr = scanner.nextLine();
		System.out.print("Digite o status do produto: ");
		String status = scanner.nextLine();

		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setQuantidade(quantidade);
		produto.setValor(valor);
		produto.setData(java.sql.Date.valueOf(dataStr));
		produto.setStatus(status);

		ProdutoController.inserirProduto(produto);
		System.out.println("Produto inserido com sucesso.");
	}

	private static void atualizarProduto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o ID do produto a ser atualizado: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consumir a quebra de linha após o número
		System.out.print("Digite o novo nome do produto: ");
		String novoNome = scanner.nextLine();
		System.out.print("Digite a nova quantidade do produto: ");
		int novaQuantidade = scanner.nextInt();
		System.out.print("Digite o novo valor do produto: ");
		double novoValor = scanner.nextDouble();
		scanner.nextLine(); // Consumir a quebra de linha após o número
		System.out.print("Digite a nova data do produto (formato: yyyy-MM-dd): ");
		String novaDataStr = scanner.nextLine();
		System.out.print("Digite o novo status do produto: ");
		String novoStatus = scanner.nextLine();

		Produto produto = new Produto();
		produto.setId(id);
		produto.setNome(novoNome);
		produto.setQuantidade(novaQuantidade);
		produto.setValor(novoValor);
		produto.setData(java.sql.Date.valueOf(novaDataStr));
		produto.setStatus(novoStatus);

		ProdutoController.atualizarProduto(produto);
		System.out.println("Produto atualizado com sucesso.");
	}

	private static void excluirProduto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o ID do produto a ser excluído: ");
		int id = scanner.nextInt();

		ProdutoController.excluirProduto(id);
		System.out.println("Produto excluído com sucesso.");
	}
}
