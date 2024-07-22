package proxy;

import java.util.ArrayList;
import java.util.List;

import interfaces.Consulta;
import produto.Produto;
import produto.ProdutoDAO;

public class ProxyProduto implements Consulta {

	private List<Produto> listaProds = new ArrayList<Produto>();
	
	@Override
	public Produto procurarProd(int id) {
		
		// Consulta pelo Proxy
		
		for(Produto prod : listaProds) {
			if(prod.getId() == id) {
				// Adicionar na lista de produtos ... ?
				System.out.println("Proxy: " + prod);
				return prod;
			}
		}
		
		// Consulta pelo banco de dados
		
		ProdutoDAO prodDAO = new ProdutoDAO();
		Produto prod = prodDAO.procurarProd(id);
		if(prod == null) {
			System.out.println("Produto não encontrado.");
			return null;
		} else {
			listaProds.add(prod);
			System.out.println("Banco de dados: " + prod);
			return prod;
		}
	}

}