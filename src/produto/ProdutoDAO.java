package produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conf.Conexao;
import interfaces.Consulta;

public class ProdutoDAO implements Consulta {

	public Produto procurarProd(int id) {
		try {
			Connection conn = Conexao.conectar();
			String sql = "SELECT * FROM produto WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Produto prod = new Produto(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				ps.close();
				rs.close();
				conn.close();
				return prod;
			} else {
				ps.close();
				rs.close();
				conn.close();
				return null;
			}
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}