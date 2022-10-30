package conexao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
	private Connection connection;
	String select = "select from tblivros where categoria=?";
	String deletar = "delete from tblivros where codlivros = ?";
	String update = "update tblivros set titulo=?, autor=?, categoria=?, valor=? where codlivro=?";
	String insert = "insert into tblivros (codlivro,titulo,autor,categoria,valor) values (?,?,?,?,?)";
	
	public LivroDAO(){
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public void cadastrar(Livro livro) {
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(insert);
			//seta os valores
			stmt.setLong(1,livro.getIdLivro());
			stmt.setString(2, livro.getTitulo());
			stmt.setString(3, livro.getAutor());
			stmt.setString(4, livro.getCategoria());	
			stmt.setFloat(5,livro.getValor());
			//executa
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public List<Livro> getLista(String s){
		
		String cat = s;
		String sql = "select * from tblivros where categoria =?";
		try {
			List<Livro> cadastro = new ArrayList<Livro>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1,cat);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto livro
				Livro livro = new Livro();
				
				livro.setIdLivro(rs.getLong("codlivro"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setCategoria(rs.getString("categoria"));
				livro.setValor(rs.getFloat("valor"));
				
				// adicionando o objeto a lista
				cadastro.add(livro);				
			}
			rs.close();
			stmt.close();
			System.out.println("Lista de Livros!!!");
			return cadastro;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Livro> getLivro(long i){
		
		long id = i;
		String sql = "select * from tblivros where codlivro =?";
		try {
			List<Livro> cadastro = new ArrayList<Livro>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1,id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto livro
				Livro livro = new Livro();
				
				livro.setIdLivro(rs.getLong("codlivro"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setCategoria(rs.getString("categoria"));
				livro.setValor(rs.getFloat("valor"));
				
				// adicionando o objeto a lista
				cadastro.add(livro);				
			}
			rs.close();
			stmt.close();
			System.out.println("Lista de Livros!!!");
			return cadastro;
		}catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
		
		public void alterar (Livro livro) {
			
			try {
				PreparedStatement stmt = connection.prepareStatement(update);
				stmt.setString(1,livro.getTitulo());
				stmt.setString(2,livro.getAutor());
				stmt.setString(3,livro.getCategoria());
				stmt.setFloat(4,livro.getValor());
				stmt.setLong(5, livro.getIdLivro());
				stmt.execute();
				System.out.println("Livro Alterado!!!");
				stmt.close();
			}catch (SQLException e) {
				throw new  RuntimeException(e);
			}
		}
		
		public void deletar(Livro livro) {
			String sql = "delete from tblivros where codlivro=?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				// setar os valores
				stmt.setLong(1, livro.getIdLivro());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
}
