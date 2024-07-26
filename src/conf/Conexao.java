package conf;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static Connection conectar() {
		try {
			String url = "jdbc:mysql://192.168.100.7/lojinha";
			return DriverManager.getConnection(url, "proxy", "");
		} catch(Exception e) {
			System.out.println("Erro: " + e.toString());
			e.printStackTrace();
			return null;
		}
	}
}