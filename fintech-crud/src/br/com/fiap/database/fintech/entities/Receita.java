package br.com.fiap.database.fintech.entities;

import java.util.Calendar;

public class Receita {
	private int cdReceita;
	private int cdUsuario;
	private double vlReceita;
	private String nmReceita;
	private Calendar dtReceita;
	private boolean stRecebido;
	private boolean stReceitaFixa;
	private String txtDescricao;

	public Receita() {
		
	}
	
	public Receita(int cdReceita, int cdUsuario, double vlReceita, String nmReceita, 
			Calendar dtReceita, boolean stRecebido, boolean stReceitaFixa, String txtDescricao) {
		super();
		this.cdReceita = cdReceita;
		this.cdUsuario = cdUsuario;
		this.vlReceita = vlReceita;
		this.nmReceita = nmReceita;
		this.dtReceita = dtReceita;
		this.stRecebido = stRecebido;
		this.stReceitaFixa = stReceitaFixa;
		this.txtDescricao = txtDescricao;
	}
	
	public Receita(int cdReceita, int cdUsuario, double vlReceita, String nmReceita, 
			Calendar dtReceita, boolean stRecebido, boolean stReceitaFixa) {
		super();
		this.cdReceita = cdReceita;
		this.cdUsuario = cdUsuario;
		this.vlReceita = vlReceita;
		this.nmReceita = nmReceita;
		this.dtReceita = dtReceita;
		this.stRecebido = stRecebido;
		this.stReceitaFixa = stReceitaFixa;
		this.txtDescricao = "";  // or null?
	}

	public int getCdReceita() {
		return cdReceita;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cd_usuario) {
		this.cdUsuario = cd_usuario;
	}
	
	public double getVlReceita() {
		return vlReceita;
	}

	public String getNmReceita() {
		return nmReceita;
	}

	public Calendar getDtReceita() {
		return dtReceita;
	}

	public boolean isStRecebido() {
		return stRecebido;
	}

	public boolean isStReceitaFixa() {
		return stReceitaFixa;
	}

	public String getTxtDescricao() {
		return txtDescricao;
	}

	public void setVlReceita(double vl_receita) {
		this.vlReceita = vl_receita;
	}

	public void setNmReceita(String nm_receita) {
		this.nmReceita = nm_receita;
	}

	public void setDtReceita(Calendar dt_receita) {
		this.dtReceita = dt_receita;
	}

	public void setStRecebido(boolean st_recebido) {
		this.stRecebido = st_recebido;
	}

	public void setStReceitaFixa(boolean st_receita_fixa) {
		this.stReceitaFixa = st_receita_fixa;
	}

	public void setTxtDescricao(String txt_descricao) {
		this.txtDescricao = txt_descricao;
	}	
	
}
