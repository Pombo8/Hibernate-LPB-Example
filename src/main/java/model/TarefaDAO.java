package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TarefaDAO {
	private EntityManagerFactory emf;
		
	public TarefaDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	public boolean inserirTarefa(String descricao, int prioridade, Usuario usuario) {
		EntityManager em = emf.createEntityManager();
		
		try {
			Tarefa tarefa = new Tarefa(descricao,prioridade,usuario);
			em.getTransaction().begin();
			em.persist(tarefa);
			em.getTransaction().commit();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
	}
	
	public Tarefa procurarTarefa(int id) {
		EntityManager em = emf.createEntityManager();
		Tarefa tarefa = null;
		
		try {
			tarefa = em.find(Tarefa.class, id);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return tarefa;
	}
}
