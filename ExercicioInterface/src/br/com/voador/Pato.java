package br.com.voador;

public class Pato implements Voador {
	private int energia;

	public Pato() {
		this.energia = 100;
	}

	@Override
	public void voar() {
		if(this.energia > 0) {
			this.energia -= 5;
			System.out.println("Estou voando como um pato! (Energia restante: " + this.energia + ")");
		}else {
			System.out.println("Não tenho energia suficiente para voar!");
		}
	}

}
