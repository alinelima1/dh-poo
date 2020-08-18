package br.com.voador;

public class SuperHomem implements Voador{
	private int experiencia;

	public SuperHomem() {
		this.experiencia = 0;
	}

	@Override
	public void voar() {
		this.experiencia += 3;
		System.out.println("Estou voando como um campeão! (Experiência acumulada: " + this.experiencia + ")");
	}

}
