package br.com.santander;

import java.util.Date;

public class Cheque {
	private double valor;
	private String bancoEmissor;
	private Date dataPagamento;
	
	public Cheque(double valor, String bancoEmissor, Date dataPagamento) {
		this.valor = valor;
		this.bancoEmissor = bancoEmissor;
		this.dataPagamento = dataPagamento;
	}

	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getBancoEmissor() {
		return bancoEmissor;
	}
	
	public void setBancoEmissor(String bancoEmissor) {
		this.bancoEmissor = bancoEmissor;
	}
	
	public Date getDataPagamento() {
		return dataPagamento;
	}
	
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	@Override
	public String toString() {
		return "Cheque [valor=" + valor + ", bancoEmissor=" + bancoEmissor + ", dataPagamento=" + dataPagamento + "]";
	}
	
	
}
