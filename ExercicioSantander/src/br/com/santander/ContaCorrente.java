package br.com.santander;

import java.util.List;

public class ContaCorrente extends Conta{
	private double chequeEspecial;
	
	public ContaCorrente() {
		super();
	}
		
	public ContaCorrente(double chequeEspecial) {
		super();
		this.chequeEspecial = chequeEspecial;
	}

	public ContaCorrente(double chequeEspecial, List<Cheque> cheques) {
		super();
		this.chequeEspecial = chequeEspecial;
	}

	public double getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}	

	@Override
	public void sacar(double valor) {
		if((this.getSaldoAtual() + this.chequeEspecial) - valor >= (this.chequeEspecial*(-1))) {
			this.setSaldoAtual(this.getSaldoAtual() - valor);
		}else {
			System.out.println("Saldo insuficiente.");
		}
	}

	@Override
	public String toString() {
		return "ContaCorrente [numConta=" + this.getNumConta() + ", saldoAtual= " + this.getSaldoAtual() + ", chequeEspecial=" + chequeEspecial + "]";
	}
	
}
