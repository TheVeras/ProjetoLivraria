package conexao;

public class TestaCadastro {

	public static void main(String[] args) {
		// gravando utilizando o obj livro
		Livro livro = new Livro();
		//testanto o input
		livro.setIdLivro(1000);
		livro.setTitulo("Teste");
		livro.setAutor("Rodrigo");
		livro.setCategoria("Arquitetura");
		livro.setValor(0f);
		
		//grave nessa conexão
		LivroDAO dao = new LivroDAO();
		//método elegante
		dao.cadastrar(livro);
		System.out.println("Livro Cadastrado!!!");
		

	}


}