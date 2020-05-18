package service;
import dao.TarefasDAO;
import model.Tarefas;

import java.util.ArrayList;


public class TarefasService {
	
	private TarefasDAO TarefasDAO;	
		
	public TarefasService() {
			this.TarefasDAO = new TarefasDAO ();
	}
	
	public void cadastrar(Tarefas tarefas) {
			this.TarefasDAO.cadastrar(tarefas);
			
		}
	
	public void alterar(Tarefas tarefas) {
		this.TarefasDAO.alterar(tarefas);
		
	}
	
	public void excluir(Tarefas tarefas) {
		this.TarefasDAO.excluir(tarefas);
	}
	
	public void consultar(Tarefas tarefas) {
		this.TarefasDAO.consultar(tarefas);
	}
	
	public ArrayList<Tarefas> listarTarefas() {
		return this.TarefasDAO.listarTarefas();
	}
	public ArrayList<Tarefas> listarTarefasFkEmail(Tarefas tarefas) {
		return this.TarefasDAO.listarTarefasFkEmail(tarefas);
	}
	
}
