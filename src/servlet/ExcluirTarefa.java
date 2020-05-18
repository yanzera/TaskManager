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


@WebServlet(name = "ExcluirTarefa.do", urlPatterns = { "/ExcluirTarefa.do" })
public class ExcluirTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
    public ExcluirTarefa() {
        super();        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int id = Integer.parseInt(request.getParameter("id_tarefa"));
		
		Tarefas tarefas = new Tarefas();
		tarefas.setId(id);
		
		TarefasService tarefasService = new TarefasService();
		tarefasService.excluir(tarefas);
		
		PrintWriter saida = response.getWriter();
		response.setContentType ("text/html");
		saida.println("Exclusão realizada com sucesso!");
		saida.println(" <a href='home.jsp'> Clique aqui para visualizar as tarefas </a>");
	}

}