package conexao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaCat")
public class Listagem extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Listagem() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LivroDAO dao = new LivroDAO();
		//Livro l = new Livro();
		PrintWriter out = response.getWriter();
		String categoria = request.getParameter("categoria");
		

		if(request.getParameter("categoria") == "arquitetura") {
			categoria = "Arquitetura";
		}else if(request.getParameter("categoria") == "design") {
			categoria = "Design";
		}else if(request.getParameter("categoria") == "informatica") {
			categoria = "Informática";
		}else if(request.getParameter("categoria") == "literaturabrasileira") {
			categoria = "Literatura brasileira";
		}else if(request.getParameter("categoria") == "literaturainfantil") {
			categoria = "Literatura infantil";
		}else if(request.getParameter("categoria") == "literaturauniversal") {
			categoria = "Literatura universal";
		}else
			categoria = "Musica e arte";
		
		//l.setCategoria(categoria);
		List<Livro> livros = dao.getLista(categoria);
		for(Livro livro : livros) {
			out.println("ID: " + livro.getIdLivro());
			out.println("Titulo: " + livro.getTitulo());
			out.println("Autor: " + livro.getAutor());
			out.println("Categoria: " + livro.getCategoria());
			out.println("Valor: " + livro.getValor());
			out.println("----------------------------------------------------");
		}
	}

}
