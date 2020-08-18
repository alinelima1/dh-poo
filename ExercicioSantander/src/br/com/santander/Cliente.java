package br.com.santander;

public class Cliente {
	private int numCliente;
	private String sobreNome;
	private String rg;
	private String cpf;
	private Conta conta;
	
	public void setNumCliente(int numCliente) {
		this.numCliente = numCliente;
	}
	
	public int getNumCliente() {
		return this.numCliente;
	}
	
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	
	public String getSobreNome() {
		return this.sobreNome;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getRg() {
		return this.rg;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return this.cpf;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return "Cliente [numCliente=" + numCliente + ", sobreNome=" + sobreNome + ", rg=" + rg + ", cpf=" + cpf
				+ ", conta=" + conta + "]\n";
	}
	
	
}
