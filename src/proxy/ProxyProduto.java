package proxy;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import interfaces.Consulta;
import produto.Produto;
import produto.ProdutoDAO;

public class ProxyProduto implements Consulta {

	private List<Produto> listaProds = new ArrayList<Produto>();
	private List<Timestamp> listaTempo = new ArrayList<Timestamp>();
	
	@Override
	public Produto procurarProd(int id) {
		
		// Consulta pelo Proxy
		
		for(int i = 0; i < listaProds.size(); i++) {
			if(listaProds.get(i).getId() == id) {
				listaTempo.get(i).setTime(System.currentTimeMillis()); // Reinicia o tempo do produto no cache
				System.out.println("Proxy: " + listaProds.get(i));
				return listaProds.get(i);
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
			listaTempo.add(new Timestamp(System.currentTimeMillis()));
			System.out.println("Banco de dados: " + prod);
			return prod;
		}
	}
	
	public void verificarTempo() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				for(int i = 0; i < listaProds.size(); i++) {
					if(System.currentTimeMillis() - 15000 >= listaTempo.get(i).getTime()) { // Verifica se o tempo limite foi atingido
						System.out.println("\n--- Removido do cache: " + listaProds.get(i) + " ---");
						listaProds.remove(i);
						listaTempo.remove(i);
					}
				}
			}
		}, 0, 1000);
	}
}