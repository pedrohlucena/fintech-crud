package br.com.fiap.fintech.view;

import java.util.Calendar;
import java.util.List;
import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.ExpenseDAO;
import br.com.fiap.fintech.dao.RevenueDAO;
import br.com.fiap.fintech.entity.Expense;
import br.com.fiap.fintech.entity.Revenue;

public class Test {

	public static void main(String[] args) {
//		RevenueDAO revenueDAO = DAOFactory.getRevenueDAO();
//
//		revenueDAO.insert(new Revenue(
//				1, 
//				30.78,
//				"Ganhei no binco",
//				Calendar.getInstance(),
//				"S",
//				"N",
//				"Ganhei no binco quinta feira passada"
//		));
		
		ExpenseDAO expenseDAO = DAOFactory.getExpenseDAO();
		List<Expense> listaDespesas = expenseDAO.getAll();
		
		for(Expense expense: listaDespesas) {
			System.out.println(expense.getExpenseName());
		}
		
//		revenueDAO.insert(new Revenue(
//				1, 
//				73.25,
//				"Aula do Leo - Todas as quartas às 21h",
//				Calendar.getInstance(),
//				"S",
//				"S",
//				"Aula do Leonardo - Todas as quintas às 21h30"
//		));
//		
//		revenueDAO.insert(new Revenue(
//				1, 
//				100,
//				"Sorteio de R$100",
//				Calendar.getInstance(),
//				"N",
//				"N",
//				"Participei de um sorteio e acabei ganhando, +100 pra conta"
//		));
//		
//		revenueDAO.insert(new Revenue(
//				1, 
//				2389.75,
//				"Salário caiu",
//				Calendar.getInstance(),
//				"S",
//				"S",
//				""
//		));
//		
//		revenueDAO.insert(new Revenue(
//				1, 
//				170,
//				"Recebimento do serviço prestado ao Sr. Omar",
//				Calendar.getInstance(),
//				"S",
//				"N",
//				"Faço bico de pedreiro as vezes, +170 pra conta!"
//		));
//		
//		Revenue revenueToBeUpdated = revenueDAO.fetchById(52);
//		
//		System.out.println(revenueToBeUpdated.getRevenueName());
//		
//		revenueToBeUpdated.setRevenueValue(60);
//		revenueToBeUpdated.setRevenueName("Instrução de meditação");
//		revenueToBeUpdated.setRevenueDate(Calendar.getInstance());
//		revenueToBeUpdated.setIsFixedRevenue("S");
//		revenueToBeUpdated.setIsReceived("S");
//		revenueToBeUpdated.setDescription("Turma 3°A - Instrução de meditação às quintas 15h");
//
//		revenueDAO.update(revenueToBeUpdated);
//			
//		List<Revenue> listOfAllRevenues = revenueDAO.getAll();
//		for(Revenue revenueItem: listOfAllRevenues) {
//			System.out.println(
//					"Código da receita: " + revenueItem.getRevenueCode() + "\n" +
//					"Código do usuário dono da receita: " + revenueItem.getUserCode() + "\n" +
//					"Nome da receita: " + revenueItem.getRevenueName() + "\n" +
//					"Descrição da receita: " + revenueItem.getDescription() + "\n\n"
//			);
//		}
//		
//		List<Revenue> listOfAllRevenuesOfAUser = revenueDAO.fetchAllByUserCode(1);
//		for(Revenue revenueItem: listOfAllRevenuesOfAUser) {
//			System.out.println(
//					"Código da receita: " + revenueItem.getRevenueCode() + "\n" +
//					"Código do usuário dono da receita: " + revenueItem.getUserCode() + "\n" +
//					"Nome da receita: " + revenueItem.getRevenueName() + "\n" +
//					"Descrição da receita: " + revenueItem.getDescription() + "\n\n"
//			);
//		}
//		
//		revenueDAO.remove(5);
	}

}
