package conexao;

import java.sql.Connection;
import java.sql.SQLException;


public class TestaConexao {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão Aberta com sucesso");
		connection.close();
		
}
		// TODO Auto-generated method stub
}
