package service;
import dao.LoginDAO;
import model.Login;

import java.util.ArrayList;


public class LoginService {
	
	private LoginDAO LoginDAO;

	public LoginService() {
			this.LoginDAO = new LoginDAO ();
	}
	
	public void cadastrar(Login login) {
			this.LoginDAO.cadastrar(login);
			
		}
	
	public void alterar(Login login) {
		this.LoginDAO.alterar(login);
		
	}
	
	public void excluir(Login login) {
		this.LoginDAO.excluir(login);
	}
	
	public Login consultar(Login login) {
		return this.LoginDAO.consultar(login);
	}
	
	
	public ArrayList<Login> listarLogins() {
		return this.LoginDAO.listarUsuarios();
	}

}
