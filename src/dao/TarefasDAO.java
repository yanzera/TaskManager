package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Tarefas;

import java.sql.ResultSet;


public class TarefasDAO {

	private Connection conexao;
	
	public TarefasDAO () {
		this.conexao = ConnectionFactory.conectar();		
	}
	
	public void cadastrar(Tarefas tarefas) {
		
		String inserir = "INSERT INTO tarefas "
				+ " (titulo, descricao,fk_usuario_email) "
				+ " VALUES (?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {			
			
			pst.setString(1, tarefas.getTitulo());
			pst.setString(2, tarefas.getDescricao());
			pst.setString(3, tarefas.getFk_usuario_email());
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular "
					+ "a tabela Tarefas.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Tarefas tarefas) {
		
		String inserir = "UPDATE tarefas "
				+ "SET titulo = ?, descricao = ? "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(2, tarefas.getDescricao());
			pst.setString(1, tarefas.getTitulo());
			pst.setInt(3, tarefas.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular "
					+ "a tabela Tarefas.");
			ex.printStackTrace();			
		}
	}
	
	public void excluir(Tarefas tarefas) {
		
		String inserir = "DELETE FROM tarefas "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, tarefas.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Tarefas.");
			ex.printStackTrace();
		}
	}
	
	public Tarefas consultar(Tarefas tarefas) {
		
		String inserir = "SELECT * FROM tarefas "
				+ " WHERE id = ?";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, tarefas.getId());
			ResultSet resultado = pst.executeQuery();
			
			Tarefas p = null;
			if (resultado.next() == true) {
				p = new Tarefas();
				p.setId(resultado.getInt("id"));
				p.setDescricao(resultado.getString("descricao"));
				p.setTitulo(resultado.getString("titulo"));
				p.setFk_usuario_email(resultado.getString("fk_usuario_email"));
				
			}
			return p;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Tarefas.");
			ex.printStackTrace();
			
			return null;
		}
	}
	
	public ArrayList<Tarefas> listarTarefas() {
		
		String inserir = "SELECT * FROM tarefas";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Tarefas> lista = new ArrayList<>();
			while (resultado.next()) {
				Tarefas p = new Tarefas();
				p.setId(resultado.getInt("id"));
				p.setTitulo(resultado.getString("titulo"));
				p.setDescricao(resultado.getString("descricao"));
				p.setFk_usuario_email(resultado.getString("fk_usuario_email"));								
				
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Tarefas.");
			ex.printStackTrace();
			
			return null;
		}
	}

	public ArrayList<Tarefas> listarTarefasFkEmail(Tarefas tarefas) {
	
		String inserir = "SELECT * FROM tarefas"
			+ " WHERE fk_usuario_email = ? ";;
	
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, tarefas.getFk_usuario_email());
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Tarefas> lista = new ArrayList<>();
			while (resultado.next()) {
				Tarefas p = new Tarefas();
				p.setId(resultado.getInt("id"));
				p.setTitulo(resultado.getString("titulo"));
				p.setDescricao(resultado.getString("descricao"));								
				p.setFk_usuario_email(resultado.getString("email"));
				
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular "
					+ "a tabela Tarefas.");
			ex.printStackTrace();
			
			return null;
		}
	}
}
