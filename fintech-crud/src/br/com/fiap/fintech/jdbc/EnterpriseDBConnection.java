package br.com.fiap.fintech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EnterpriseDBConnection {
	
	private static EnterpriseDBConnection instance;
	
	private EnterpriseDBConnection(){}

	public static EnterpriseDBConnection getInstance() {
		if (instance == null)
		    instance = new EnterpriseDBConnection();		
		return instance;	
	}
	
	public Connection getConnection(){	
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
					"user", 
					"password"
			);
			
			return connection;
		} catch (SQLException e) {
			System.err.println("Não foi possível conectar no Banco de Dados");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("O Driver JDBC não foi encontrado!");
			e.printStackTrace();
		}
		return connection;
	}
}

