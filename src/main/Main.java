package main;

import proxy.ProxyProduto;

public class Main {
	public static void main(String[] args) {
		
		ProxyProduto consulta = new ProxyProduto();
		consulta.procurarProd(1);
		
		consulta.procurarProd(1);
		
	}
}