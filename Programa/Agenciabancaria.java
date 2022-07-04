package Programa;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Agenciabancaria {

	// nossa agencia bancaria tem varias contas precisamos de uma lista de contas
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {

		// instanciando contasBancarias
		contasBancarias = new ArrayList<Conta>(); // arrayList do tipo <Conta>

		// criando um menu de operações sacar ou transferir ou depositar
		operacoes();

	}

	public static void operacoes() {

		int operacao = Integer.parseInt(JOptionPane.showInputDialog("--- Selecione uma operação ---" +"\n"
				+ "|		Opção 1 - Criar conta" + "\n" + "|		Opção 2 - Depositar" + "\n" +"|		Opção 3 - Sacar"
				+ "\n" +"|		Opção 4 - Transferir" + "\n" +"|		Opção 5 - Listar" + "\n" + "|		Opção 6 - Sair"));

		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			JOptionPane.showMessageDialog(null, " Obrigado por usar nossa agência");
			System.exit(0); // system.exit sai do programa

		default: // caso usuário digitar alguma opção que não tenha
			JOptionPane.showMessageDialog(null, " Opção inválida");
			operacoes(); // aqui chama menu principal operacoes pq n quer sair por ter digitado numero
							// errado quero que chama menu denovo
			break;

		}

	}

	// criando o método criar conta que fizemos no switch
	// aqui precisamos de nome, cpf, e-mail e passar essa pessoa em uma conta e a
	// conta e uma lista de conta
	public static void criarConta() {

		Pessoa pessoa = new Pessoa();

		pessoa.setNome(JOptionPane.showInputDialog("Nome"));
		pessoa.setNome(JOptionPane.showInputDialog("CPF"));
		pessoa.setNome(JOptionPane.showInputDialog("Email"));

		// aqui a gente quer adicionar essa pessoa a essa conta
		Conta conta = new Conta(pessoa);

		// preciso adicionar essa conta a cima na minha lista de contas
		// aqui chamo meu metodo contasBancarias.add e ele ja passa minha conta aqui
		contasBancarias.add(conta);

		JOptionPane.showMessageDialog(null, " Sua conta foi criada com sucesso");

		// agora chamo meu metodo operacoes denovo para saber qual a proxima opção que o
		// usuário quer fazer
		operacoes();

	}

	// precisamos agora fazer metodo para contar uma conta com usuário digitar a
	// conta
	// vamos criar o método encontrarConta que recebe o numero que o usuário digitar
	private static Conta encontrarConta(int numeroConta) {
		// tem que retornar alguma coisa, retornar como null pq se a conta exitir a
		// gente vai retornar
		Conta conta = null;
		// aqui precisa saber se a conta existe vamos conferir a lista de contas da
		// nossa agencia bancaria
		if (contasBancarias.size() > 0) { // chamo a contasBancaria.size esse tamo tem que ser maior que 0, precisa
											// conter algo pra ser existente
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta) { // se essa conta dentro da conta bancaria foir igual ao numero
															// da conta q usuario digitou
					conta = c; // inves de ser num ela vai receber conta c
				}

			}
		}

		return conta;

	}

	// metodo depositar
	public static void depositar() {

		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog(" Numero da conta para deposito:"));

		// passo esse numero para a minha conta
		// chamo o metodo encontrarConta e passo o numero da conta que o usuario digitou
		// para ele
		Conta conta = encontrarConta(numeroConta); // vai realizar a logica do metodo encontrar conta pra ver se existe
		if (conta != null) {
			Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog(" Qual valor deseja depositar")); 
																													 
			conta.depositar(valorDeposito); // vai passar esse valor para o metodo depositar
			JOptionPane.showMessageDialog(null, " Valor foi depositado com sucesso");
		} else { // se for valor positivo ele vai dizer a mensagem acima se for negativo menor
					// que zero mensagem a baixo
			JOptionPane.showMessageDialog(null, " Conta nao encontrada!");
		}

		operacoes(); // menu de opcao de usuarios
	}

	// metodo sacar parecido com o metodo depositar
	public static void sacar() {
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Numero da Conta"));
	
		Conta conta = encontrarConta(numeroConta); // vou ver se essa conta existe

		if (conta != null) { // se a conta existir
			System.out.println("Qual valor deseja sacar ?");
			Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar?")); // pergunto valor que vai sacar
			conta.sacar(valorSaque); // passo esse valor para o meu metodo sacar, pra ver se o valor e >0 e se tem
										// saldo se tiver subtrai do saldo

		} else { // se nao ele vai dar mesagem abaixo
			JOptionPane.showMessageDialog(null, " Conta nao encontrada!");

		}

		operacoes(); // menu de opcao de usuarios

	}

	// metodo trasnferir
	// preciso ter uma conta que vai enviar a transferencia e a conta que vai
	// receber a transferencia
	public static void transferir() {
		int numeroContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("Numero da Conta do remetente"));
		
		// vou criar uma contaRemetente e ver se ela existe pra estar realizando
		// tranasferencia
		Conta contaRemetente = encontrarConta(numeroContaRemetente); // chama o metodo encontrarConta e vou passar o
																		// (numeroContaRemetente)

		if (contaRemetente != null) { // se conta do remetente existir e for diferente de null
			int numeroContaDestinatario = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta do destinatario:"));
			
			// chamo o metodo encontrarConta para quem eu quero transferir existe
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

			// se a conta de destinatario exixtir ou diferente de null
			if (contaDestinatario != null) {
				
			Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferencia"));

				// pego minha contaRemetente chamo o metodo transferir, passo minha
				// contaDestinaratio e o valor
				contaRemetente.transferir(contaDestinatario, valor);
			} else {
				JOptionPane.showMessageDialog(null, " A conta para deposito nao foi encontrada");
			}
		} else {
			JOptionPane.showMessageDialog(null, " Conta para transferencia nao encontrada");
		}

		operacoes();
	}

	// metodo ver/listar conta
	public static void listarContas() {
		if (contasBancarias.size() > 0) { // se minha lista de contas bacarias for maior > 0 vou percorrer a lista
			for (Conta conta : contasBancarias) { // para cada conta dentro da minha lista de contaBancarias
				JOptionPane.showMessageDialog(null, conta);
			}

		} else { // caso contrario informo que n tem contas cadastradas
			JOptionPane.showMessageDialog(null, " Nao ha contas cadastradas");
		}
		operacoes();
	}

}
