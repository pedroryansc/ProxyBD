package cliente;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import proxy.ProxyProduto;

public class Servidor {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		try {
			ServerSocket servidor = new ServerSocket(1234, 0, InetAddress.getByName("26.120.76.41"));
			System.out.println(servidor.getInetAddress());
			System.out.println("Servidor ouvindo a porta 1234");
		    while(true) {
		    	Socket cliente = servidor.accept();
		        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
		        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
		        saida.flush();
		        saida.writeObject(new Date());
		        saida.close();
		        cliente.close();
		    }
		} catch(Exception e) {
		       System.out.println("Erro: " + e.getMessage());
		    }
		
		/*
		ProxyProduto consulta = new ProxyProduto();
		
		consulta.verificarTempo();
		
		consulta.procurarProd(1);
		
		Thread.sleep(14000);
		
		consulta.procurarProd(1);
		
		Thread.sleep(20000);
		
		consulta.procurarProd(1);
		
		consulta.procurarProd(1);
		*/
		
	}
}