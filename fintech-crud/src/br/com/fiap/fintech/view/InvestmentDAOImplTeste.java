package br.com.fiap.fintech.view;

import java.util.Calendar;
import java.util.List;
import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.InvestmentDAO;
import br.com.fiap.fintech.dao.RevenueDAO;
import br.com.fiap.fintech.entity.Investment;
import br.com.fiap.fintech.entity.Revenue;

public class InvestmentDAOImplTeste {

	public static void main(String[] args) {
		InvestmentDAO investmentDAO = DAOFactory.getInvestmentDAO();

		investmentDAO.insert(new Investment(
				1,
				1, 
				30.78,
				"gastou",
				Calendar.getInstance(),
				100.0,
				50.0,
				50.0
		));
	}}