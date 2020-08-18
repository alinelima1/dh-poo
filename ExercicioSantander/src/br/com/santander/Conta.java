package br.com.santander;

public abstract class Conta {
	private int numConta;
	private double saldoAtual;
	
	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}
	
	public double getSaldoAtual() {
		return this.saldoAtual;
	}	

	public void depositar(double valor) {
		this.saldoAtual += valor;
	}
	
	public void sacar(double valor) {
		if(this.saldoAtual - valor >= 0) {
			this.saldoAtual -= valor;
		}else {
			System.out.println("Saldo insuficiente.");
		}
	}

}
