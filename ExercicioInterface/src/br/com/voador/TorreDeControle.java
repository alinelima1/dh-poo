package br.com.voador;

import java.util.*;

public class TorreDeControle {
	List<Voador> voadores = new ArrayList<Voador>();
	
	public TorreDeControle(List<Voador> voadores) {
		super();
		this.voadores = voadores;
	}

	public void voemTodos() {
		voadores.forEach(e -> e.voar());
	}
	
}
