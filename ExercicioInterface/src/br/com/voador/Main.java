package br.com.voador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Pato pato = new Pato();
		Aviao aviao = new Aviao();
		SuperHomem superHomem = new SuperHomem();
		List<Voador> voadores = new ArrayList<Voador>();
		voadores.add(pato); 
		voadores.add(aviao); 
		voadores.add(superHomem);
		TorreDeControle torreDeControle = new TorreDeControle(voadores);
		
		Scanner input = new Scanner(System.in);
		int option = -1;
		
		do {
			System.out.println("\nDigite 1 para executar e 0 para sair: ");
			option = input.nextInt();
			
			if(option == 1) {
				System.out.println("**************************");
				torreDeControle.voemTodos();
				System.out.println("**************************");
			}else {
				System.out.println("Até logo!");
			}
			
		}while(option == 1);		
		

	}
}
