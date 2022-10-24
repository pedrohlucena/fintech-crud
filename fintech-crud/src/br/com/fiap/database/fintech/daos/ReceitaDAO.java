package br.com.fiap.database.fintech.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.database.fintech.EnterpriseDBConnection;
import br.com.fiap.database.fintech.entities.Receita;

public class ReceitaDAO {
	
	private Connection connection;
	
	public ReceitaDAO(Connection connection) {
		this.connection = EnterpriseDBConnection.connect();;
	}
	  
    public void insert(Receita receita) {
      PreparedStatement stmt = null;
  
      try {
        
	    String sql = "INSERT INTO T_RECEITA (cd_receita, cd_usuario, vl_receita, nm_receita, dt_receita, st_recebido, st_receita_fixa, txt_descricao) " +
	    		 	 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    
	    stmt = connection.prepareStatement(sql);
	    stmt.setInt(1, receita.getCdReceita());
	    stmt.setInt(2, receita.getCdUsuario());
	    stmt.setDouble(3, receita.getVlReceita());
	    stmt.setString(4, receita.getNmReceita());
	    java.sql.Date dataReceitaRecebida = new java.sql.Date(receita.getDtReceita().getTimeInMillis());
	    stmt.setDate(5, dataReceitaRecebida);  
	    stmt.setBoolean(6, receita.isStRecebido());
	    stmt.setBoolean(7, receita.isStReceitaFixa());
	    stmt.setString(8, receita.getTxtDescricao());
      
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

    public List<Receita> getAll() {
    	List<Receita> lista = new ArrayList<Receita>();
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	try {
    		stmt = connection.prepareStatement("SELECT * FROM T_RECEITA");
    		rs = stmt.executeQuery();
    		while (rs.next()) {
    		    int cdReceita = rs.getInt("cd_receita");
    		    int cdUsuario = rs.getInt("cd_usuario");
    			double vlReceita = rs.getDouble("vl_receita");
    			String nmReceita = rs.getString("nm_receita");
		        java.sql.Date data = rs.getDate("dt_receita");		
		        Calendar dataReceita = Calendar.getInstance();
		        dataReceita.setTimeInMillis(data.getTime());		        
    			boolean stRecebido = rs.getBoolean("st_recebido");
    			boolean stReceitaFixa = rs.getBoolean("st_receita_fixa");
    			String txtDescricao = rs.getString("txt_descricao");		        

		        //Cria um objeto Receita com as informações encontradas
		        Receita receita = new Receita(cdReceita, cdUsuario, vlReceita, nmReceita, 
		        		dataReceita, stRecebido, stReceitaFixa, txtDescricao);
		        
		        //Adiciona a receita na lista
		        lista.add(receita);
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
    	return lista;
    }

}




    
    