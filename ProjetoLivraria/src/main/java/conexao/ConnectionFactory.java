package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws ClassNotFoundException  {
		try {
			//Class.forName("com.mysql.jdbc.Driver"); registro manual do drive
			// duas formas diferentes antigo e novo (abaixo) e precisar� ClassNot
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(
				"jdbc:mysql://localhost/bdlivraria?useTimezone=true&serverTimezone=UTC","root","Conector327199");
			//?useTimezone=true&serverTimezone=UTC
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
