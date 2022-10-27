package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.entity.Expense;
import br.com.fiap.fintech.jdbc.EnterpriseDBConnection;

public class ExpenseDAOImpl implements ExpenseDAO {
	private Connection connection;

	private PreparedStatement stmt;

	@Override
	public void insert(Expense expense) {
		this.connection = null;
		this.stmt = null;

		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();

			String sql = "INSERT INTO T_DESPESA (cd_despesa, cd_usuario, vl_despesa, nm_despesa, "
					+ "dt_despesa, st_pago, st_despesa_fixa, txt_descricao) " + 
			          "VALUES (SEQ_DESPESA.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";	

			this.stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, expense.getUserCode());
			stmt.setDouble(2, expense.getExpenseValue());
			stmt.setString(3, expense.getExpenseName());
			java.sql.Date data = new java.sql.Date(expense.getExpenseDate().getTimeInMillis());
			stmt.setDate(4, data);
			stmt.setString(5, expense.getIsReceived());
			stmt.setString(6, expense.getIsFixedExpense());
			stmt.setString(7, expense.getDescription());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.stmt.close();
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} 

	@Override
	public List<Expense> getAll() {
		this.stmt = null;
		List<Expense> expenseList = new ArrayList<Expense>();
		ResultSet result = null;
		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM T_DESPESA");
			result = stmt.executeQuery();

			Expense expense = null;
			while (result.next()) {
				java.sql.Date data = result.getDate("dt_despesa");
				Calendar expenseDate = Calendar.getInstance();
				expenseDate.setTimeInMillis(data.getTime());

				expense = new Expense(
						result.getInt("cd_despesa"), 
						result.getInt("cd_usuario"),
						result.getDouble("vl_despesa"), 
						result.getString("nm_despesa"), 
						expenseDate,
						result.getString("st_pago"),
						result.getString("st_despesa_fixa"), 
						result.getString("txt_descricao")
				);

				expenseList.add(expense);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				result.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return expenseList;
	}

	@Override
	public void remove(int expenseCode) {
		this.stmt = null;
		
		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();

			stmt = connection.prepareStatement("DELETE FROM T_DESPESA WHERE cd_despesa = ?");
			stmt.setInt(1, expenseCode);
			stmt.executeUpdate();
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Expense fetchById(int expenseCode) {
		this.stmt = null;
		Expense expense = null;
		ResultSet result = null;

		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();

			this.stmt = this.connection.prepareStatement("SELECT * FROM T_DESPESA WHERE cd_despesa = ?");
			this.stmt.setInt(1, expenseCode);

			result = this.stmt.executeQuery();

			if (result.next()) {
				java.sql.Date data = result.getDate("dt_despesa");
				Calendar expenseDate = Calendar.getInstance();
				expenseDate.setTimeInMillis(data.getTime());

				expense = new Expense(
						result.getInt("cd_despesa"),
						result.getInt("cd_usuario"),
						result.getDouble("vl_despesa"),
						result.getString("nm_despesa"),
						expenseDate,
						result.getString("st_pago"),
						result.getString("st_despesa_fixa"),
						result.getString("txt_descricao")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				result.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return expense;
	}
	
	@Override
	public List<Expense> fetchAllByUserCode(int userCode) {
		this.stmt = null;
		List<Expense> expenseList = new ArrayList<Expense>();
		ResultSet result = null;

		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();

			stmt = connection.prepareStatement("SELECT * FROM T_DESPESA WHERE cd_usuario = ?");
			stmt.setInt(1, userCode);

			result = stmt.executeQuery();
			
			Expense expense = null;
			
			while (result.next()) {
				java.sql.Date data = result.getDate("dt_despesa");
				Calendar expenseDate = Calendar.getInstance();
				expenseDate.setTimeInMillis(data.getTime());

				expense = new Expense(
						result.getInt("cd_despesa"), 
						result.getInt("cd_usuario"),
						result.getDouble("vl_despesa"), 
						result.getString("nm_despesa"), 
						expenseDate,
						result.getString("st_pago"),
						result.getString("st_despesa_fixa"), 
						result.getString("txt_descricao")
				);

				expenseList.add(expense);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return expenseList;
	}

	@Override
	public void update(Expense expense) {
		this.stmt = null;

		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();

			String sql = "UPDATE T_DESPESA SET cd_usuario = ?, vl_despesa = ?, nm_despesa = ?, txt_descricao = ? ,dt_despesa = ?, st_pago = ?, st_despesa_fixa = ? WHERE cd_despesa = ?";

			stmt = connection.prepareStatement(sql);

			java.sql.Date data = new java.sql.Date(expense.getExpenseDate().getTimeInMillis());

			stmt.setDouble(1, expense.getUserCode());
			stmt.setDouble(2, expense.getExpenseValue());
			stmt.setString(3, expense.getExpenseName());
			stmt.setString(4, expense.getDescription());
			stmt.setDate(5, data);
			stmt.setString(6, expense.getIsReceived());
			stmt.setString(7, expense.getIsFixedExpense());
			stmt.setInt(8, expense.getExpenseCode());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}