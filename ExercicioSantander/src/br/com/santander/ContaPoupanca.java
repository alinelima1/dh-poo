package br.com.santander;

public class ContaPoupanca extends Conta{
	private double juros;
	private double ultimoRendimento;
	private boolean recolheuJuros;
	
	public ContaPoupanca() {
		super();
	}
	
	public ContaPoupanca(double juros) {
		super();
		this.juros = juros;
	}

	public double getjuros() {
		return juros;
	}

	public void setjuros(double juros) {
		this.juros = juros;
	}
	
	public double getUltimoRendimento() {
		return ultimoRendimento;
	}

	public void setUltimoRendimento(double ultimoRendimento) { // Calcula o rendimento de acordo com o juro e já soma ao saldo
		this.ultimoRendimento = ultimoRendimento;
	}

	public boolean isRecolheuJuros() {
		return recolheuJuros;
	}

	public void setRecolheuJuros(boolean recolheuJuros) {
		this.recolheuJuros = recolheuJuros;
	}
	
	public void calculaRendimento() { // Calcula o rendimento
		this.ultimoRendimento = (this.getSaldoAtual() * this.juros/100);
		this.setSaldoAtual(this.getSaldoAtual() + this.ultimoRendimento);
	}

	public void recolherJuros() { //Não entendi bem o que seria o recolhimento dos juros, considerei saque do rendimento dos juros
		if(!recolheuJuros) {
			this.sacar(this.ultimoRendimento);
		}else {
			System.out.println("O rendimento referente à este mês já foi recolhido.");
		}
	}

	@Override
	public String toString() {
		return "ContaPoupanca [numConta=" + this.getNumConta() + ", saldoAtual=" + this.getSaldoAtual() + ", juros=" + juros + ", ultimoRendimento=" + ultimoRendimento + ", recolheuJuros="
				+ recolheuJuros + "]";
	}
	
	
	
}
