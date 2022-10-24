package br.com.fiap.database.fintech;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.database.fintech.daos.ReceitaDAO;
import br.com.fiap.database.fintech.entities.Receita;

public class Testes {

	public static void main(String[] args) {
		
		// Cria a conexão única para uso de todos os DAOs
		Connection connection = EnterpriseDBConnection.connect();	
		
		// Instancia o DAO de Receita, a classe responsável pela interação com o banco
		ReceitaDAO dao = new ReceitaDAO(connection);	
		
		// Instancia os objetos que representam registros para o DAO inserir no banco 
		Receita receita1 = new Receita(1, 1, 76.45, "Venda Jequiti", Calendar.getInstance(), true , false);
		Receita receita2 = new Receita(2, 1, 123.85, "Venda Avon", Calendar.getInstance(), true , false);
		Receita receita3 = new Receita(3, 1, 30, "Venda Yakult", Calendar.getInstance(), false , true);

		
		// INTERAGINDO COM O BANCO DE DADOS
		dao.insert(receita1);
		dao.insert(receita2);
		dao.insert(receita3);
		System.out.println("Receita Registrada com sucesso!");
		
		List<Receita> listaDeReceitas = dao.getAll();
		for(Receita r: listaDeReceitas) {
			System.out.println(String.format("CÓDIGO: %d | VALOR: %.2f | NOME: %s", r.getCdReceita(), r.getVlReceita(), r.getNmReceita()));
		}
		
		
	}

}
