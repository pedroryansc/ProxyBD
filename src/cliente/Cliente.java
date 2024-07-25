package cliente;

import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

public class Cliente {
	public static void main(String[] args) {
		
		try {
	    	Socket cliente = new Socket(InetAddress.getByName("26.163.173.71"), 1234);
	    	ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
	    	Date data_atual = (Date) entrada.readObject();
	    	System.out.println("Data recebida do servidor: " + data_atual.toString());
	    	entrada.close();
	    	System.out.println("Conexão encerrada");
	    } catch(Exception e) {
	    	System.out.println("Erro: " + e.getMessage());
	    }
	}
}