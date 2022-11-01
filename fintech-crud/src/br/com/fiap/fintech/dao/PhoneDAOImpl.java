package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.entity.Phone;
import br.com.fiap.fintech.jdbc.EnterpriseDBConnection;

public class PhoneDAOImpl implements PhoneDAO {
	private Connection connection;

	private PreparedStatement stmt;

	@Override
	public void insert(Phone phone) {
		this.connection = null;
		this.stmt = null;

		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();

			String sql = "INSERT INTO T_TELEFONE (cd_completo, cd_usuario, ds_tipo, nr_telefone, nr_ddi, nr_ddd) " + 
			             "VALUES (SEQ_TELEFONE.NEXTVAL, ?, ?, ?, ?, ?)";
			

			this.stmt = connection.prepareStatement(sql);
			
            stmt.setInt(1, phone.getUserCode());
            stmt.setString(2, phone.getType());
            stmt.setInt(3, phone.getPhoneNumber());
            stmt.setInt(4, phone.getDDI());
            stmt.setInt(5, phone.getDDD());

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
	public List<Phone> getAll() {
		this.stmt = null;
		List<Phone> phoneList = new ArrayList<Phone>();
		ResultSet result = null;
		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM T_TELEFONE");
			result = stmt.executeQuery();

			Phone phone = null;
			while (result.next()) {

				phone = new Phone(
						result.getInt("cd_completo"), 
						result.getInt("cd_usuario"),
						result.getInt("nr_telefone"), 
						result.getInt("nr_ddi"), 
						result.getInt("nr_ddd"),
						result.getString("ds_tipo") 
				);

				phoneList.add(phone);
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

		return phoneList;
	}

	@Override
	public void remove(int phoneCode) {
		this.stmt = null;
		
		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();

			stmt = connection.prepareStatement("DELETE FROM T_TELEFONE WHERE cd_completo = ?");
			stmt.setInt(1, phoneCode);
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
	public Phone fetchById(int phoneCode) {
		this.stmt = null;
		Phone phone = null;
		ResultSet result = null;

		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();

			this.stmt = this.connection.prepareStatement("SELECT * FROM T_TELEFONE WHERE cd_completo = ?");
			this.stmt.setInt(1, phoneCode);

			result = this.stmt.executeQuery();

			if (result.next()) {

				phone = new Phone(
						result.getInt("cd_completo"), 
						result.getInt("cd_usuario"),
						result.getInt("nr_telefone"), 
						result.getInt("nr_ddi"), 
						result.getInt("nr_ddd"),
						result.getString("ds_tipo")
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

		return phone;
	}
	
	@Override
	public List<Phone> fetchAllByUserCode(int userCode) {
		this.stmt = null;
		List<Phone> phoneList = new ArrayList<Phone>();
		ResultSet result = null;

		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();

			stmt = connection.prepareStatement("SELECT * FROM T_TELEFONE WHERE cd_usuario = ?");
			stmt.setInt(1, userCode);

			result = stmt.executeQuery();
			
			Phone phone = null;
			
			while (result.next()) {

				phone = new Phone(
						result.getInt("cd_completo"), 
						result.getInt("cd_usuario"),
						result.getInt("nr_telefone"), 
						result.getInt("nr_ddi"), 
						result.getInt("nr_ddd"),
						result.getString("ds_tipo")
				);

				phoneList.add(phone);
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
		
		return phoneList;
	}

	@Override
	public void update(Phone phone) {
		this.stmt = null;

		try {
			this.connection = EnterpriseDBConnection.getInstance().getConnection();

			String sql = "UPDATE T_TELEFONE SET cd_usuario = ?, ds_tipo = ?, nr_telefone = ? ,nr_ddi = ?, nr_ddd = ? WHERE cd_completo = ?";

			stmt = connection.prepareStatement(sql);

			stmt.setInt(1, phone.getUserCode());
            stmt.setString(2, phone.getType());
            stmt.setInt(3, phone.getPhoneNumber());
            stmt.setInt(4, phone.getDDI());
            stmt.setInt(5, phone.getDDD());
            stmt.setInt(6, phone.getPhoneCode());
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
