package br.com.fiap.fintech.view;

import java.util.List;
import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.ExpenseDAO;
import br.com.fiap.fintech.entity.Expense;

public class ExpenseImplTest {

	public static void main(String[] args) {
		ExpenseDAO expenseDAO = DAOFactory.getExpenseDAO();
		List<Expense> listaDespesas = expenseDAO.getAll();
		
		for(Expense expense: listaDespesas) {
			System.out.println(expense.getExpenseName());
		}
		
	}

}
