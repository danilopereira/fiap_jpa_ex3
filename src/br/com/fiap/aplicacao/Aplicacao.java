package br.com.fiap.aplicacao;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Agenda;
import br.com.fiap.entity.MaterialMedico;
import br.com.fiap.entity.Paciente;
import br.com.fiap.entity.Procedimento;
import br.com.fiap.helper.Helper;

public class Aplicacao {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("fiap_jpa_ex3");
		EntityManager em = emf.createEntityManager();
		
		Helper helper = new Helper(em);
		try{
			Agenda agenda = new Agenda();
			agenda.setDescricao("Consulta Geral Médica");
			agenda.setData(new Date(System.currentTimeMillis()));
			agenda.setHora(new Date(System.currentTimeMillis()));
			
			Procedimento procedimento = new Procedimento();
			procedimento.setDescricao("Remoção de lesão dermatologica");
			procedimento.setPreco(125);
			
			MaterialMedico matMed = new MaterialMedico();
			matMed.setDescricao("Bisturi");
			matMed.setFabricante("Bistumed Ltda");
			matMed.setPreco(250);
			
			Paciente paciente = new Paciente();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			paciente.setCpf("12345678900");
			paciente.setDataNascimento(sdf.parse("18/05/1993"));
			paciente.setNome("Danilo Pereira");
			paciente.setTelefone("11 985667631");
			paciente.getMateriaisMedicos().add(matMed);
			paciente.getProcedimentos().add(procedimento);
			
			paciente.getAgendas().add(agenda);
			matMed.setPaciente(paciente);
			procedimento.setPaciente(paciente);
			agenda.getPacientes().add(paciente);
			
			helper.salvar(agenda);
			
			helper.listaPacienteMatMed().forEach(p->{
				System.out.println(p.getCpf() + ": " + p.getNome() + p.getProcedimentos());

			});
			
			
		}
		catch(Exception e){
			
		}
		
		

	}

}
