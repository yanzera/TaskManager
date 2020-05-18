package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import model.Login;

import service.LoginService;

@WebServlet(name = "ConectarLogin.do", urlPatterns = { "/ConectarLogin.do" })
public class ConectarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ConectarLogin() {
        super();       
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");		
		
		//Instanciar objeto tipo Login:		
		Login login = new Login();	
		login.setEmail(email);
		login.setSenha(senha);

		// enviar o objeto login para a service:
		LoginService loginService = new LoginService();		
		
		Login temp = loginService.consultar(login);
		
			if(temp == null) {
				request.setAttribute("mensagem", "Usuário e/ou Senha inválido, favor tentar novamente");
				request.getRequestDispatcher ("login.jsp").forward(request, response);							
			}
			else {
				HttpSession sessao = request.getSession();
				sessao.setAttribute("usuario", temp);
				response.sendRedirect("home.jsp");				
			}
								 		
		}
	
	}