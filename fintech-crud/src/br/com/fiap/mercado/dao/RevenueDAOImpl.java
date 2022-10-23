package br.com.fiap.mercado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.mercado.entity.Revenue;
import br.com.fiap.mercado.jdbc.EnterpriseDBConnection;

public class RevenueDAOImpl {
	private Connection connection;

	private PreparedStatement stmt;

	public void save(Revenue revenue) {
		this.connection = null;
		this.stmt = null;

		try {
			this.connection = EnterpriseDBConnection.connect();

			String sql = "INSERT INTO T_RECEITA (cd_receita, cd_usuario, vl_receita, nm_receita, dt_receita, st_recebido, st_receita_fixa, txt_descricao) " + 
			             "VALUES (SEQ_RECEITA.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
			
			java.sql.Date data = new java.sql.Date(revenue.getRevenueDate().getTimeInMillis());

			this.stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, revenue.getUserCode());
			stmt.setDouble(2, revenue.getRevenueValue());
			stmt.setString(3, revenue.getRevenueName());
			stmt.setDate(4, data);
			stmt.setString(5, revenue.getIsReceived());
			stmt.setString(6, revenue.getIsFixedRevenue());
			stmt.setString(7, revenue.getDescription());

			stmt.executeUpdate();

			System.out.println("BLABLBLA");
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

	public List<Revenue> list() {
		this.stmt = null;
		List<Revenue> revenueList = new ArrayList<Revenue>();
		ResultSet result = null;
		try {
			this.connection = EnterpriseDBConnection.connect();
			stmt = connection.prepareStatement("SELECT * FROM T_RECEITA");
			result = stmt.executeQuery();

			Revenue revenue = null;
			while (result.next()) {
				java.sql.Date data = result.getDate("dt_receita");
				Calendar revenueDate = Calendar.getInstance();
				revenueDate.setTimeInMillis(data.getTime());

				revenue = new Revenue(
						result.getInt("cd_receita"), 
						result.getInt("cd_usuario"),
						result.getDouble("vl_receita"), 
						result.getString("nm_receita"), 
						revenueDate,
						result.getString("st_recebido"),
						result.getString("st_receita_fixa"), 
						result.getString("txt_descricao")
				);

				revenueList.add(revenue);
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

		return revenueList;
	}

	public void remove(int revenueCode) {
		this.stmt = null;
		
		try {
			this.connection = EnterpriseDBConnection.connect();

			stmt = connection.prepareStatement("DELETE FROM T_RECEITA WHERE cd_receita = ?");
			stmt.setInt(1, revenueCode);
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

	public Revenue fetchById(int revenueCode) {
		this.stmt = null;
		Revenue revenue = null;
		ResultSet result = null;

		try {
			this.connection = EnterpriseDBConnection.connect();

			this.stmt = this.connection.prepareStatement("SELECT * FROM T_RECEITA WHERE cd_receita = ?");
			this.stmt.setInt(1, revenueCode);

			result = this.stmt.executeQuery();

			if (result.next()) {
				System.out.println("entrei");
				java.sql.Date data = result.getDate("dt_receita");
				Calendar revenueDate = Calendar.getInstance();
				revenueDate.setTimeInMillis(data.getTime());

				revenue = new Revenue(
						result.getInt("cd_receita"),
						result.getInt("cd_usuario"),
						result.getDouble("vl_receita"),
						result.getString("nm_receita"),
						revenueDate,
						result.getString("st_recebido"),
						result.getString("st_receita_fixa"),
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

		return revenue;
	}
	
	public List<Revenue> fetchAllByUserCode(int userCode) {
		this.stmt = null;
		List<Revenue> revenueList = new ArrayList<Revenue>();
		ResultSet result = null;

		try {
			this.connection = EnterpriseDBConnection.connect();

			stmt = connection.prepareStatement("SELECT * FROM T_RECEITA WHERE cd_usuario = ?");
			stmt.setInt(1, userCode);

			result = stmt.executeQuery();
			
			Revenue revenue = null;
			
			while (result.next()) {
				java.sql.Date data = result.getDate("dt_receita");
				Calendar revenueDate = Calendar.getInstance();
				revenueDate.setTimeInMillis(data.getTime());

				revenue = new Revenue(
						result.getInt("cd_receita"), 
						result.getInt("cd_usuario"),
						result.getDouble("vl_receita"), 
						result.getString("nm_receita"), 
						revenueDate,
						result.getString("st_recebido"),
						result.getString("st_receita_fixa"), 
						result.getString("txt_descricao")
				);

				revenueList.add(revenue);
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
		
		return revenueList;
	}

	public void update(Revenue revenue) {
		this.stmt = null;

		try {
			this.connection = EnterpriseDBConnection.connect();

			String sql = "UPDATE T_RECEITA SET cd_usuario = ?, vl_receita = ?, nm_receita = ?, txt_descricao = ? ,dt_receita = ?, st_recebido = ?, st_receita_fixa = ? WHERE cd_receita = ?";

			stmt = connection.prepareStatement(sql);

			java.sql.Date data = new java.sql.Date(revenue.getRevenueDate().getTimeInMillis());

			stmt.setDouble(1, revenue.getUserCode());
			stmt.setDouble(2, revenue.getRevenueValue());
			stmt.setString(3, revenue.getRevenueName());
			stmt.setString(4, revenue.getDescription());
			stmt.setDate(5, data);
			stmt.setString(6, revenue.getIsReceived());
			stmt.setString(7, revenue.getIsFixedRevenue());
			stmt.setInt(8, revenue.getRevenueCode());

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