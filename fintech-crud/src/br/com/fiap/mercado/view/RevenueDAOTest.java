package br.com.fiap.mercado.view;

import java.util.Calendar;
import java.util.List;

public class RevenueDAOTest {

	public static void main(String[] args) {
		RevenueDAO revenueDAO = new RevenueDAO();
		
		Revenue revenueToBeCreated = new Revenue(
				1, 
				73.25,
				"Aula do Leo - Todas as quartas às 21h",
				Calendar.getInstance(),
				"S",
				"S",
				"Aula do Leonardo - Todas as quintas às 21h30"
		);

		revenueDAO.save(revenueToBeCreated);
		
		Revenue revenueToBeUpdated = revenueDAO.fetchById(52);
		
		System.out.println(revenueToBeUpdated.getRevenueName());
		
		revenueToBeUpdated.setRevenueValue(60);
		revenueToBeUpdated.setRevenueName("Instrução de meditação");
		revenueToBeUpdated.setRevenueDate(Calendar.getInstance());
		revenueToBeUpdated.setIsFixedRevenue("S");
		revenueToBeUpdated.setIsReceived("S");
		revenueToBeUpdated.setDescription("Turma 3°A - Instrução de meditação às quintas 15h");

		revenueDAO.update(revenueToBeUpdated);
			
		List<Revenue> revenueList = revenueDAO.list();
		for(Revenue revenueItem: revenueList) {
			System.out.println(
					"Código da receita: " + revenueItem.getRevenueCode() + "\n" +
					"Código do usuário dono da receita: " + revenueItem.getUserCode() + "\n" +
					"Nome da receita: " + revenueItem.getRevenueName() + "\n" +
					"Descrição da receita: " + revenueItem.getDescription() + "\n\n"
			);
		}
		
		revenueDAO.remove(5);
	}

}
