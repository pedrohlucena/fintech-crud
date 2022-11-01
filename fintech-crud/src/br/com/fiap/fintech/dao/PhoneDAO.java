package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.entity.Phone;

public interface PhoneDAO {
	void insert (Phone phone);
	List<Phone> getAll();
	void remove (int code);
	Phone fetchById (int phoneCode);
	List<Phone> fetchAllByUserCode(int userCode);
	void update (Phone phone);
}

