package conexao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cadastrar
 */
@WebServlet("/Cadastrar") 
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		Livro livro = new Livro();
		LivroDAO dao = new LivroDAO();
		ArrayList<String> botoes = new ArrayList<String>();
		botoes.add("cad");
		botoes.add("exc");
		botoes.add("alt");
		String btn = request.getParameter("btn");
		
		
		for(int i = 0; i<botoes.size();i++) {
			if(btn.equals(botoes.get(i))){
				btn = botoes.get(i);
			}
		}
		
		
		switch(btn) {
		
		case "cad":
			
			int cod ;
			float preco ;
		
			
			String id = request.getParameter("codlivro");
			String titulo = request.getParameter("titulo");
			String autor = request.getParameter("autor");
			String categoria;
			String valor = request.getParameter("valor");
		
			
		
			cod = Integer.parseInt(id); 
			preco = Float.parseFloat(valor); 
		
			if(request.getParameter("categoria") == "arquitetura") {
				categoria = "Arquitetura";
			}else if(request.getParameter("categoria") == "design") {
				categoria = "Design";
			}else if(request.getParameter("categoria") == "informatica") {
				categoria = "Informatica";
			}else if(request.getParameter("categoria") == "literaturabrasileira") {
				categoria = "Literatura Brasileira";
			}else if(request.getParameter("categoria") == "literaturainfantil") {
				categoria = "Literatura Infantil";
			}else if(request.getParameter("categoria") == "literaturauniversal") {
				categoria = "Literatura Universal";
			}else
				categoria = "Musica e Arte";
		       
			livro.setIdLivro(cod);
			livro.setTitulo(titulo);
			livro.setAutor(autor);
			livro.setCategoria(categoria);
			livro.setValor(preco);
		
			try {
				
				dao.cadastrar(livro);
				out.println("<html>");
				out.println("<body>");
				out.println("Livro " + livro.getTitulo() + " foi adicionado");
				out.println("</body>");
				out.println("</html>");
			}catch(Throwable e) {
					out.println("ERRO, por favor preencha todos os campos corretamente");
				e.printStackTrace();
			}
			
			break;
			
		case "exc":
			int cod2 = Integer.parseInt(request.getParameter("codlivro"));
			Livro livro1 = new Livro();
			livro1.setIdLivro(cod2);
			
			try {
				
				dao.deletar(livro1);
				out.println("<html>");
				out.println("<body>");
				out.println("Excluido com Sucesso");
				out.println("</body>");
				out.println("</html>");
			}catch(Throwable e) {
					out.println("ERRO, Verifique o ID");
				e.printStackTrace();
			}
			
			break;
			
		case "alt":
			Livro livro3 = new Livro();
			
			
			int idA = Integer.parseInt(request.getParameter("codlivro"));
			String titulo2 = request.getParameter("titulo");
			String autor2 = request.getParameter("autor");
			String categoria2;
			float valor2 = Float.parseFloat(request.getParameter("valor"));
			
			if(request.getParameter("categoria") == "arquitetura") {
				categoria2 = "Arquitetura";
			}else if(request.getParameter("categoria") == "design") {
				categoria2 = "Design";
			}else if(request.getParameter("categoria") == "informatica") {
				categoria2 = "Informatica";
			}else if(request.getParameter("categoria") == "literaturabrasileira") {
				categoria2 = "Literatura Brasileira";
			}else if(request.getParameter("categoria") == "literaturainfantil") {
				categoria2 = "Literatura Infantil";
			}else if(request.getParameter("categoria") == "literaturauniversal") {
				categoria2 = "Literatura Universal";
			}else
				categoria2 = "Musica e Arte";
		    livro3.setIdLivro(idA);
			livro3.setTitulo(titulo2);
			livro3.setAutor(autor2);
			livro3.setCategoria(categoria2);
			livro3.setValor(valor2);
		
			try {
				
				dao.alterar(livro3);
				out.println("<html>");
				out.println("<body>");
				out.println("Alterado com Sucesso");
				out.println("</body>");
				out.println("</html>");
			}catch(Throwable e) {
					out.println("Erro, verifique o ID");
				e.printStackTrace();
			}
			
			break;

			
		}
		
	}
	

}
