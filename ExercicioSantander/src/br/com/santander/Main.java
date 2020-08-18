package br.com.santander;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<HistoricoCheque> cheques = new ArrayList<HistoricoCheque>();
		Random random = new Random();
		SimpleDateFormat dtFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner input = new Scanner(System.in);
		int option = 0;
		
		do {
			System.out.println(
			"*****Digite uma das opções*****\n" +
			"1) Cadastrar cliente/conta.\n" +
			"2) Realizar depósito.\n" +
			"3) Realizar saque.\n" +
			"4) Recolher juros de poupança.\n"+
			"5) Alterar configurações de conta.\n"+
			"6) Processar rendimentos mensais (geral).\n"+
			"7) Ver histórico de cheques depositados (geral).\n"+
			"8) Ver histórico de cheques depositados (por conta).\n"+
			"9) Sair.\n"+
			"********************************\n"
			);
			option = input.nextInt();
			switch(option) {
			case 1: // Cadastrar cliente/conta.
				Cliente newCliente = new Cliente();
				Conta conta;
				newCliente.setNumCliente(clientes.size() + 1);				
				newCliente.setSobreNome(input.nextLine());
				System.out.println("Informe o sobrenome do cliente:");
				newCliente.setSobreNome(input.nextLine());
				System.out.println("Informe o RG do cliente:");
				newCliente.setRg(input.nextLine());
				System.out.println("Informe o CPF do cliente:");
				newCliente.setCpf(input.nextLine());
				int typeConta = 0;
				do {
					System.out.println("Informe o tipo de conta a ser aberta:\n1) Para Conta Corrente\n2) Para conta Poupança\n");
					typeConta = input.nextInt();
					if(typeConta == 1) {
						System.out.println("Informe o valor do cheque especial:");
						conta = new ContaCorrente(input.nextDouble());
						System.out.println("Informe o valor do depósito inicial:");
						conta.setSaldoAtual(input.nextDouble());
						conta.setNumConta(random.nextInt(1000));
						newCliente.setConta(conta);
					}else if(typeConta == 2) {
						System.out.println("Informe o valor do juro mensal:");
						conta = new ContaPoupanca(input.nextDouble());
						System.out.println("Informe o valor do depósito inicial:");
						conta.setSaldoAtual(input.nextDouble());
						conta.setNumConta(random.nextInt(1000));
						newCliente.setConta(conta);
					}else {
						System.out.println("Tente novamente.");
					}
				}while(typeConta != 1 && typeConta != 2);
				clientes.add(newCliente);
				System.out.println(clientes.toString());
				System.out.println("Conta cadastrada com sucesso");
				break;
			case 2: // Realizar depósito. (validar se é em dinheiro ou cheque - no caso de conta corrente)
				System.out.println("Informe o número da conta:");
				int aux = input.nextInt();
				int index = -1;
				for(int x = 0; x < clientes.size(); x++) {
					if(aux == clientes.get(x).getConta().getNumConta()) {
						index = x;
					}
				}
				
				if(index != -1) {
					aux = 1;
					if(clientes.get(index).getConta().getClass().getSimpleName().equals("ContaCorrente")) {
						System.out.println("Digite o tipo de depósito:\n1) Dinheiro\n2) Cheque");
						aux = input.nextInt();
					}					
					System.out.println("Digite o valor à ser depositado");
					double val = input.nextDouble();
					if(val > 0) {
						clientes.get(index).getConta().depositar(val);
						if(aux == 2) {
							String bancoEmissor;
							Date dataPagamento = new Date();
							input.nextLine();
							System.out.println("Informe o banco emissor do cheque:");
							bancoEmissor = input.nextLine();
							System.out.println("Informe a data de pagamento do cheque:");
							dataPagamento = dtFormat.parse(input.nextLine());
							Cheque ch = new Cheque(val, bancoEmissor, dataPagamento);
							cheques.add(new HistoricoCheque(ch,clientes.get(index).getConta()));
						}
						System.out.println("Depósito realizado com sucesso");
					}else {
						System.out.println("Valor inválido.");
					}						
				}else {
					System.out.println("Conta não encontrada.");
				}
				break;
			case 3: // Realizar saque. 
				System.out.println("Informe o número da conta:");
				aux = input.nextInt();
				index = -1;
				for(int x = 0; x < clientes.size(); x++) {
					if(aux == clientes.get(x).getConta().getNumConta()) {
						index = x;
					}
				}
				
				if(index != -1) {
					System.out.println("Informe o valor do saque:");
					double val = input.nextDouble();
					if(val > 0) {
						clientes.get(index).getConta().sacar(val);
						System.out.println("Saque realizado com sucesso");
					}else {
						System.out.println("Valor inválido.");
					}						
					
				}else {
					System.out.println("Conta não encontrada.");
				}
				break;
			case 4: // Recolher juros de poupança.
				System.out.println("Informe o número da conta:");
				aux = input.nextInt();
				index = -1;
				for(int x = 0; x < clientes.size(); x++) {
					if(aux == clientes.get(x).getConta().getNumConta()) {
						index = x;
					}
				}
				
				if(index != -1) {
					if(clientes.get(index).getConta().getClass().getSimpleName().equals("ContaPoupanca")) {
						ContaPoupanca cp = (ContaPoupanca) clientes.get(index).getConta();
						double saldoAtual = cp.getSaldoAtual();
						cp.recolherJuros();
						clientes.get(index).setConta(cp);
						System.out.println("***********************************");
						System.out.println("Conta: "+clientes.get(index).getConta().getNumConta());
						System.out.println("Saldo anterior: " + saldoAtual);
						System.out.println("Rendimento recolhido: "+ cp.getUltimoRendimento());
						System.out.println("Saldo atual: " + cp.getSaldoAtual());
						System.out.println("***********************************");
					}else {
						System.out.println("Conta não é poupança.");
					}
				}else {
					System.out.println("Conta não encontrada.");
				}
				break;
			case 5: // Alterar configurações de conta.
				System.out.println("Informe o número da conta:");
				aux = input.nextInt();
				index = -1;
				for(int x = 0; x < clientes.size(); x++) {
					if(aux == clientes.get(x).getConta().getNumConta()) {
						index = x;
					}
				}
				
				if(index != -1) {
					if(clientes.get(index).getConta().getClass().getSimpleName().equals("ContaPoupanca")) {
						ContaPoupanca cp = (ContaPoupanca) clientes.get(index).getConta();
						double juroAtual = cp.getjuros();
						System.out.println("Informe o novo juro desta poupança:");
						cp.setjuros(input.nextDouble());
						clientes.get(index).setConta(cp);
						System.out.println("***********************************");
						System.out.println("Conta: "+clientes.get(index).getConta().getNumConta());
						System.out.println("Juro anterior: " + juroAtual);
						System.out.println("Juro atual: " + cp.getjuros());
						System.out.println("***********************************");
					}else {
						ContaCorrente cc = (ContaCorrente) clientes.get(index).getConta();
						double chEspecialAtual = cc.getChequeEspecial();
						System.out.println("Informe o novo limite de cheque especial desta conta corrente:");
						cc.setChequeEspecial(input.nextDouble());
						clientes.get(index).setConta(cc);
						System.out.println("***********************************");
						System.out.println("Conta: "+clientes.get(index).getConta().getNumConta());
						System.out.println("Cheque especial anterior: " + chEspecialAtual);
						System.out.println("Cheque especial atual: " + cc.getChequeEspecial());
						System.out.println("***********************************");
					}
				}else {
					System.out.println("Conta não encontrada.");
				}
				break;
			case 6: // Processar rendimentos mensais.
				for(int i = 0; i < clientes.size(); i++) {
					if(clientes.get(i).getConta().getClass().getSimpleName().equals("ContaPoupanca")) {
						ContaPoupanca cp = (ContaPoupanca) clientes.get(i).getConta();
						double saldoAtual = cp.getSaldoAtual();
						cp.calculaRendimento();
						clientes.get(i).setConta(cp);
						System.out.println("***********************************");
						System.out.println("Conta: "+clientes.get(i).getConta().getNumConta());
						System.out.println("Saldo anterior: " + saldoAtual);
						System.out.println("Rendimento: "+ cp.getUltimoRendimento());
						System.out.println("Saldo atual: " + cp.getSaldoAtual());
						System.out.println("***********************************");
					}
				}
				break;
			case 7: // Ver histórico de cheques depositados (geral)
				cheques.forEach(System.out::println);
				break;
			case 8: // Ver histórico de cheques depositados (por conta)
				System.out.println("Informe o número da conta:");
				aux = input.nextInt();
				int count = 0;
				for(int x = 0; x < cheques.size(); x++) {
					if(aux == cheques.get(x).getConta().getNumConta()) {
						count++;
						System.out.println(cheques.get(x).toString());
					}
				}
				
				if(count == 0) {
					System.out.println("Não encontramos depósito de cheques para esta conta.");
				}
				break;
			case 9: // Sair
				System.out.println("Obrigada por utilizar nosso sistema!");
                System.exit(0);
			default:
				System.out.println("Opção inválida!");
				break;
			}
			System.out.println("Digite enter para continuar.");
			try {
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(option != 9);
		
	}
}
