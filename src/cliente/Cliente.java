package cliente;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import produto.Produto;

public class Cliente {
	public static void main(String[] args) {
		try {
	    	Socket cliente = new Socket(InetAddress.getByName("192.168.100.7"), 1234);
	    	
	    	Scanner scanner = new Scanner(System.in);
	    	
	    	ObjectOutputStream entrada = new ObjectOutputStream(cliente.getOutputStream());
	    	entrada.flush();
	    	
	    	System.out.println("Insira o ID do produto para consultá-lo:");
	    	entrada.writeObject(scanner.nextInt());

	    	ObjectInputStream saida = new ObjectInputStream(cliente.getInputStream());
	    	Produto prod = (Produto) saida.readObject();
	    	System.out.println("Produto recebido: " + prod + "\n");
	    	
	    	scanner.close();
	    	entrada.close();
	    	saida.close();
	    	
	    	System.out.println("Conexão encerrada");
	    } catch(Exception e) {
	    	System.out.println("Erro: " + e.getMessage());
	    }
	}
}