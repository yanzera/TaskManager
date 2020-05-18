package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Logoff.do", urlPatterns = { "/Logoff.do" })
public class Logoff extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Logoff() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		HttpSession sessao = request.getSession();
		
		sessao.invalidate();					
		response.sendRedirect("login.jsp");
	}

}