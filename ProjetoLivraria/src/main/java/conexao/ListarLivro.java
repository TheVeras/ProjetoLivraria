package conexao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listarLivro")
public class ListarLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarLivro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LivroDAO dao = new LivroDAO();
		//Livro l = new Livro();
		PrintWriter out = response.getWriter();
		long id = Integer.parseInt(request.getParameter("codlivro"));
		
		try {
		
			List<Livro> livros = dao.getLivro(id);
			for(Livro livro : livros) {
				out.println("ID: " + livro.getIdLivro());
				out.println("Titulo: " + livro.getTitulo());
				out.println("Autor: " + livro.getAutor());
				out.println("Categoria: " + livro.getCategoria());
				out.println("Valor: " + livro.getValor());
				out.println("----------------------------------------------------");
			}
			
		}catch(Throwable e) {
			out.println("ERRO, ID inexistente");
		e.printStackTrace();
			}
		
		}
	}
