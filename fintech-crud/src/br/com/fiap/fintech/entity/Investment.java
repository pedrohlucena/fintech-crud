package br.com.fiap.fintech.entity;

import java.io.Serializable;
import java.util.Calendar;

public class Investment implements Serializable {
	private static final long serialVersionUID = 1L;
	private	int investmentCode;
	private int userCode;
	private double investmentValue;
	private String investmentName;
	private Calendar investmentDate;
	private double earnedValue;
	private double lostValue;
	private double balance;
	
	public Investment () { super(); }

	public Investment(int investmentCode, int userCode, double investmentValue, String investmentName,
			Calendar investmentDate, double earnedValue, double lostValue, double balance) {
		super();
		this.investmentCode = investmentCode;
		this.userCode = userCode;
		this.investmentValue = investmentValue;
		this.investmentName = investmentName;
		this.investmentDate = investmentDate;
		this.earnedValue = earnedValue;
		this.lostValue = lostValue;
		this.balance = balance;
	}

	public Investment(int userCode, double investmentValue, String investmentName, Calendar investmentDate,
			double earnedValue, double lostValue, double balance) {
		super();
		this.userCode = userCode;
		this.investmentValue = investmentValue;
		this.investmentName = investmentName;
		this.investmentDate = investmentDate;
		this.earnedValue = earnedValue;
		this.lostValue = lostValue;
		this.balance = balance;
	}

	public int getInvestmentCode() {
		return investmentCode;
	}

	public void setInvestmentCode(int investmentCode) {
		this.investmentCode = investmentCode;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public double getInvestmentValue() {
		return investmentValue;
	}

	public void setInvestmentValue(double investmentValue) {
		this.investmentValue = investmentValue;
	}

	public String getInvestmentName() {
		return investmentName;
	}

	public void setInvestmentName(String investmentName) {
		this.investmentName = investmentName;
	}

	public Calendar getInvestmentDate() {
		return investmentDate;
	}

	public void setInvestmentDate(Calendar investmentDate) {
		this.investmentDate = investmentDate;
	}

	public double getEarnedValue() {
		return earnedValue;
	}

	public void setEarnedValue(double earnedValue) {
		this.earnedValue = earnedValue;
	}

	public double getLostValue() {
		return lostValue;
	}

	public void setLostValue(double lostValue) {
		this.lostValue = lostValue;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	};
	
}