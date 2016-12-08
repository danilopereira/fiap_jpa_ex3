package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import br.com.fiap.entity.Agenda;
import br.com.fiap.entity.MaterialMedico;
import br.com.fiap.entity.Paciente;
import br.com.fiap.entity.Procedimento;

public class Helper {
	EntityManager em;
	
	public Helper(EntityManager em){
		this.em = em;
	}
	
	public void salvar(Agenda agenda){
		em.getTransaction().begin();
		em.persist(agenda);
		em.getTransaction().commit();
	}
	
	//Equivalente a select p from Paciente p;
	@SuppressWarnings("unchecked")
	public List<Paciente> listaPacienteMatMed() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Paciente> p = cb.createQuery(Paciente.class);
		Root<Procedimento> pr = p.from(Procedimento.class);
		Join<Procedimento, Paciente> phones = pr.join("paciente");
		p.select(phones);

		List<Paciente> results = em.createQuery(p).getResultList();

		return results;
	}

	
	
	
	

}
