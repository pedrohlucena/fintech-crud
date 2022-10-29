package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.entity.Investment;
import br.com.fiap.fintech.jdbc.EnterpriseDBConnection;

public class InvestmentDAOImpl implements InvestmentDAO {
	private Connection connection;

	private PreparedStatement stmt;

	@Override
	public void insert(Investment investment) {
		this.connection = null;
		this.stmt = null;

		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();

			String sql = "INSERT INTO T_INVESTIMENTO (cd_investimento, cd_usuario, nm_investimento, vl_investimento, vl_ganhos, vl_perda, vl_saldo, dt_investimento)" + 
			             "VALUES (SEQ_INVESTIMENTO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
			
			java.sql.Date data = new java.sql.Date(investment.getInvestmentDate().getTimeInMillis());

			this.stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, investment.getUserCode());
			stmt.setString(2, investment.getInvestmentName());
			stmt.setDouble(3, investment.getInvestmentValue());
			stmt.setDouble(4, investment.getEarnedValue());
			stmt.setDouble(5, investment.getLostValue());
			stmt.setDouble(6, investment.getBalance());
			stmt.setDate(7, data);

			//stmt.executeUpdate();
			stmt.execute();
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
	public List<Investment> getAll() {
		this.stmt = null;
		List<Investment> investmentList = new ArrayList<Investment>();
		ResultSet result = null;
		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM T_INVESTIMENTO");
			result = stmt.executeQuery();

			Investment investment = null;
			while (result.next()) {
				java.sql.Date data = result.getDate("dt_investimento");
				Calendar investmentDate = Calendar.getInstance();
				investmentDate.setTimeInMillis(data.getTime());

				investment = new Investment(
						result.getInt("cd_investimento"), 
						result.getInt("cd_usuario"),
						result.getDouble("vl_investimento"), 
						result.getString("nm_investimento"), 
						investmentDate,
						result.getDouble("vl_ganhos"),
						result.getDouble("vl_perda"), 
						result.getDouble("vl_saldo")
				);

				investmentList.add(investment);
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

		return investmentList;
	}

	@Override
	public void remove(int investmentCode) {
		this.stmt = null;
		
		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();

			stmt = connection.prepareStatement("DELETE FROM T_INVESTIMENTO WHERE cd_investimento = ?");
			stmt.setInt(1, investmentCode);
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
	public Investment fetchById(int investmentCode) {
		this.stmt = null;
		Investment investment = null;
		ResultSet result = null;

		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();

			this.stmt = this.connection.prepareStatement("SELECT * FROM T_INVESTIMENTO WHERE cd_investimento = ?");
			this.stmt.setInt(1, investmentCode);

			result = this.stmt.executeQuery();

			if (result.next()) {
				java.sql.Date data = result.getDate("dt_investimento");
				Calendar investmentDate = Calendar.getInstance();
				investmentDate.setTimeInMillis(data.getTime());

				investment = new Investment(
						result.getInt("cd_investimento"), 
						result.getInt("cd_usuario"),
						result.getDouble("vl_investimento"), 
						result.getString("nm_investimento"), 
						investmentDate,
						result.getDouble("vl_ganhos"),
						result.getDouble("vl_perda"), 
						result.getDouble("vl_saldo")
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

		return investment;
	}
	
	@Override
	public List<Investment> fetchAllByUserCode(int userCode) {
		this.stmt = null;
		List<Investment> investmentList = new ArrayList<Investment>();
		ResultSet result = null;

		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();

			stmt = connection.prepareStatement("SELECT * FROM T_INVESTIMENTO WHERE cd_usuario = ?");
			stmt.setInt(1, userCode);

			result = stmt.executeQuery();
			
			Investment investment = null;
			
			while (result.next()) {
				java.sql.Date data = result.getDate("dt_investimento");
				Calendar investmentDate = Calendar.getInstance();
				investmentDate.setTimeInMillis(data.getTime());

				investment = new Investment(
						result.getInt("cd_investimento"), 
						result.getInt("cd_usuario"),
						result.getDouble("vl_investimento"), 
						result.getString("nm_investimento"), 
						investmentDate,
						result.getDouble("vl_ganhos"),
						result.getDouble("vl_perda"), 
						result.getDouble("vl_saldo")
				);

				investmentList.add(investment);
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
		
		return investmentList;
	}

	@Override
	public void update(Investment investment) {
		this.stmt = null;

		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();

			String sql = "UPDATE T_INVESTIMENTO SET cd_usuario = ?, vl_investimento = ?, nm_investimento = ?, vl_saldo = ? ,dt_investimento = ?, vl_ganhos = ?, vl_perda = ? WHERE cd_investimento = ?";

			stmt = connection.prepareStatement(sql);

			java.sql.Date data = new java.sql.Date(investment.getInvestmentDate().getTimeInMillis());

			this.stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, investment.getUserCode());
			stmt.setDouble(2, investment.getInvestmentValue());
			stmt.setString(3, investment.getInvestmentName());
			stmt.setDouble(4, investment.getBalance());
			stmt.setDate(5, data);
			stmt.setDouble(6, investment.getEarnedValue());
			stmt.setDouble(7, investment.getLostValue());
			stmt.setInt(8, investment.getInvestmentCode());

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