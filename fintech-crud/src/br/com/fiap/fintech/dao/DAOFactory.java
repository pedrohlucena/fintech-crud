package br.com.fiap.fintech.dao;

public abstract class DAOFactory {
	public static RevenueDAO getRevenueDAO() {
		return new RevenueDAOImpl();
	}
	public static ExpenseDAO getExpenseDAO() {
		return new ExpenseDAOImpl();
	}
	public static InvestmentDAO getInvestmentDAO() {
		return new InvestmentDAOImpl();
	}
}
