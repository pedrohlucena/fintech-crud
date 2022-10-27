package br.com.fiap.fintech.entity;

import java.io.Serializable;
import java.util.Calendar;

public class Expense implements Serializable {
	private static final long serialVersionUID = 1L;
	private int expenseCode;
	private int userCode;
	private double expenseValue;
	private String expenseName;
	private Calendar expenseDate;
	private String isReceived;
	private String isFixedExpense;
	private String description;
	
	public Expense () { super(); };
	
	public Expense(int userCode, double expenseValue, String expenseName, Calendar expenseDate,
			String isReceived, String isFixedExpense, String description) {
		super();
		this.userCode = userCode;
		this.expenseValue = expenseValue;
		this.expenseName = expenseName;
		this.expenseDate = expenseDate;
		this.isReceived = isReceived;
		this.isFixedExpense = isFixedExpense;
		this.description = description;
	}
	
	public Expense(int expenseCode, int userCode, double expenseValue, String expenseName, Calendar expenseDate,
			String isReceived, String isFixedExpense, String description) {
		super();
		this.expenseCode = expenseCode;
		this.userCode = userCode;
		this.expenseValue = expenseValue;
		this.expenseName = expenseName;
		this.expenseDate = expenseDate;
		this.isReceived = isReceived;
		this.isFixedExpense = isFixedExpense;
		this.description = description;
	}
	
	public int getExpenseCode() {
		return expenseCode;
	}

	public int getUserCode() {
		return userCode;
	}

	public double getExpenseValue() {
		return expenseValue;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public Calendar getExpenseDate() {
		return expenseDate;
	}

	public String getIsReceived() {
		return isReceived;
	}

	public String getIsFixedExpense() {
		return isFixedExpense;
	}

	public String getDescription() {
		return description;
	}

	public void setExpenseValue(double expenseValue) {
		this.expenseValue = expenseValue;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public void setExpenseDate(Calendar expenseDate) {
		this.expenseDate = expenseDate;
	}

	public void setIsReceived(String isReceived) {
		this.isReceived = isReceived;
	}

	public void setIsFixedExpense(String isFixedExpense) {
		this.isFixedExpense = isFixedExpense;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
