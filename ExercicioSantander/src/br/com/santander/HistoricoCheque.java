package br.com.santander;

import java.util.ArrayList;
import java.util.List;

public class HistoricoCheque {
	private Cheque cheque;
	private Conta conta;
	
	public HistoricoCheque(Cheque cheque, Conta conta) {
		this.cheque = cheque;
		this.conta = conta;
	}
	
	

	public Cheque getCheque() {
		return cheque;
	}



	public void setCheque(Cheque cheque) {
		this.cheque = cheque;
	}



	public Conta getConta() {
		return conta;
	}



	public void setConta(Conta conta) {
		this.conta = conta;
	}



	@Override
	public String toString() {
		return "HistoricoCheque [cheque=" + cheque + ", conta=" + conta + "]";
	}
	
}
