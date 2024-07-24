package cliente;

import proxy.ProxyProduto;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		ProxyProduto consulta = new ProxyProduto();
		
		consulta.verificarTempo();
		
		consulta.procurarProd(1);
		
		Thread.sleep(14000);
		
		consulta.procurarProd(1);
		
		Thread.sleep(20000);
		
		consulta.procurarProd(1);
		
		consulta.procurarProd(1);
		
	}
}