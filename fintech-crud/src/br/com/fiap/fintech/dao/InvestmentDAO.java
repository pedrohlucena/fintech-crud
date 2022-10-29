package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.entity.Investment;

public interface InvestmentDAO {
	void insert (Investment investment);
	List<Investment> getAll();
	void remove (int code);
	Investment fetchById (int investmentCode);
	List<Investment> fetchAllByUserCode(int userCode);
	void update (Investment investment);
}
