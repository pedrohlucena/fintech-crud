package br.com.fiap.mercado.dao;

public abstract class DAOFactory {
	public static RevenueDAO getRevenueDAO() {
		return new RevenueDAOImpl();
	}
}
