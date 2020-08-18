package br.com.voador;

public class Aviao implements Voador{
	private int horasVoo;
	
	public Aviao() {
		this.horasVoo = 0;
	}

	@Override
	public void voar() {
		this.horasVoo += 13;
		System.out.println("Estou voando como um avião, e tenho " + this.horasVoo + " horas de voo!");
	}

}
