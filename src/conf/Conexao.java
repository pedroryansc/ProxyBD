package conf;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static Connection conectar() {
		try {
			String url = "jdbc:mysql://localhost/lojinha";
			return DriverManager.getConnection(url, "root", "");
		} catch(Exception e) {
			System.out.println("Erro: " + e.toString());
			e.printStackTrace();
			return null;
		}
	}
	
}