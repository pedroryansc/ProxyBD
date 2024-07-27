package proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import produto.Produto;

public class Servidor {
	public static void main(String[] args){
		try {
			ServerSocket servidor = new ServerSocket(1234, 0, InetAddress.getByName("192.168.100.7"));
			
			ProxyProduto proxy = new ProxyProduto();
			proxy.verificarTempo();
			
			System.out.println("Servidor ouvindo a porta 1234");
			while(true) {
				Socket cliente = servidor.accept();
				System.out.println("\nCliente conectado: " + cliente.getInetAddress().getHostAddress());
				
				ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
				
				int id = (int) entrada.readObject();
				
				if(id > 0) {
					System.out.println("ID enviado: " + id);
					
					Produto prod = proxy.procurarProd(id);
					
					ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
					saida.flush();
					saida.writeObject(prod);
					
					saida.close();
					cliente.close();
				}
				
				entrada.close();
			}
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}