package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Login;

import java.sql.ResultSet;


public class LoginDAO {

	private Connection conexao;
	
	public LoginDAO () {
		this.conexao = ConnectionFactory.conectar();		
	}
	
	public void cadastrar(Login login) {
		
		String inserir = "INSERT INTO usuario "
				+ " (email, senha, nome) "
				+ " VALUES (?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {			
			
			pst.setString(1, login.getEmail());
			pst.setString(2, login.getSenha());
			pst.setString(3, login.getNome());
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Login login) {
		
		String inserir = "UPDATE usuario "
				+ "SET nome = ?, senha = ? "
				+ " WHERE email = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, login.getNome());
			pst.setString(2, login.getSenha());
			pst.setString(3, login.getEmail());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Login login) {
		
		String inserir = "DELETE FROM usuario "
				+ " WHERE email = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, login.getEmail());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Comentario.");
			ex.printStackTrace();
		}
	}
	
	public Login consultar(Login login) {
		
		String inserir = "SELECT * FROM usuario "
				+ " WHERE email = ? AND senha =  ?";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, login.getEmail());
			pst.setString(2, login.getSenha());
			ResultSet resultado = pst.executeQuery();
			
			Login p = null;
			if (resultado.next() == true) {
				p = new Login();
				p.setNome(resultado.getString("nome"));
				p.setEmail(resultado.getString("email"));
				p.setSenha(resultado.getString("senha"));
				
			}
			return p;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular "
					+ "a tabela Usuario.");
			ex.printStackTrace();
			
			return null;
		}
	}
	
public ArrayList<Login> listarUsuarios() {
		
		String inserir = "SELECT * FROM usuario";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Login> lista = new ArrayList<>();
			while (resultado.next()) {
				Login p = new Login();
				p.setNome(resultado.getString("nome"));
				p.setEmail(resultado.getString("email"));
				p.setSenha(resultado.getString("senha"));								
				
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
			return null;
		}
	}

}
