package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tarefas;
import service.TarefasService;

@WebServlet(name = "IncluirTarefa.do", urlPatterns = { "/IncluirTarefa.do" })
public class IncluirTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public IncluirTarefa() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");		
		String email = request.getParameter("email");
		
		Tarefas tarefas = new Tarefas();
		
		tarefas.setTitulo(titulo);
		tarefas.setDescricao(descricao);
		tarefas.setFk_usuario_email(email);
				
		TarefasService tarefasService = new TarefasService();
		tarefasService.cadastrar(tarefas);
		
		PrintWriter saida = response.getWriter();
		response.setContentType ("text/html");
		saida.println("Cadastro efetuado com sucesso!");
		saida.println(" <a href='home.jsp'> Clique aqui para listar as tarefas </a>");	
	}
}