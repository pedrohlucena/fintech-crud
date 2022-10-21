package br.com.fiap.mercado.view;

import java.io.Serializable;
import java.util.Calendar;

public class Revenue implements Serializable {
	private static final long serialVersionUID = 1L;
	int revenueCode;
	int userCode;
	double revenueValue;
	String revenueName;
	Calendar revenueDate;
	String isReceived;
	String isFixedRevenue;
	String description;
	
	public Revenue () { super(); };
	
	public Revenue(int userCode, double revenueValue, String revenueName, Calendar revenueDate,
			String isReceived, String isFixedRevenue, String description) {
		super();
		this.userCode = userCode;
		this.revenueValue = revenueValue;
		this.revenueName = revenueName;
		this.revenueDate = revenueDate;
		this.isReceived = isReceived;
		this.isFixedRevenue = isFixedRevenue;
		this.description = description;
	}
	
	public Revenue(int revenueCode, int userCode, double revenueValue, String revenueName, Calendar revenueDate,
			String isReceived, String isFixedRevenue, String description) {
		super();
		this.revenueCode = revenueCode;
		this.userCode = userCode;
		this.revenueValue = revenueValue;
		this.revenueName = revenueName;
		this.revenueDate = revenueDate;
		this.isReceived = isReceived;
		this.isFixedRevenue = isFixedRevenue;
		this.description = description;
	}
	
	public int getRevenueCode() {
		return revenueCode;
	}

	public int getUserCode() {
		return userCode;
	}

	public double getRevenueValue() {
		return revenueValue;
	}

	public String getRevenueName() {
		return revenueName;
	}

	public Calendar getRevenueDate() {
		return revenueDate;
	}

	public String getIsReceived() {
		return isReceived;
	}

	public String getIsFixedRevenue() {
		return isFixedRevenue;
	}

	public String getDescription() {
		return description;
	}

	public void setRevenueValue(double revenueValue) {
		this.revenueValue = revenueValue;
	}

	public void setRevenueName(String revenueName) {
		this.revenueName = revenueName;
	}

	public void setRevenueDate(Calendar revenueDate) {
		this.revenueDate = revenueDate;
	}

	public void setIsReceived(String isReceived) {
		this.isReceived = isReceived;
	}

	public void setIsFixedRevenue(String isFixedRevenue) {
		this.isFixedRevenue = isFixedRevenue;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
