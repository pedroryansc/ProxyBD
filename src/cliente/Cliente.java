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
	    	Scanner scanner = new Scanner(System.in);
	    	int idScan;
	    	
	    	do {
	    		Socket cliente = new Socket(InetAddress.getByName("192.168.100.7"), 1234);
	    		
	    		System.out.println("Insira o ID do produto para consultá-lo (ou qualquer número <= 0 para encerrar):");
		    	idScan = scanner.nextInt();
		    	
		    	ObjectOutputStream entrada = new ObjectOutputStream(cliente.getOutputStream());
			    entrada.flush();
			    entrada.writeObject(idScan);
			    
			    if(idScan > 0) {
			    	ObjectInputStream saida = new ObjectInputStream(cliente.getInputStream());
			    	Produto prod = (Produto) saida.readObject();
			    	System.out.println("Produto recebido: " + prod + "\n");
			    	
			    	entrada.close();
			    	saida.close();
		    	}	
	    	} while (idScan > 0);
	    	
	    	scanner.close();
	    	
	    	System.out.println("\nConexão encerrada");
	    } catch(Exception e) {
	    	System.out.println("Erro: " + e.getMessage());
	    }
	}
}