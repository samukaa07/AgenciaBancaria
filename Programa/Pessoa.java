package Programa;

public class Pessoa {

private static int counter = 1;
	
	private String nome;
	private String cpf;
	private String email;
	
	public Pessoa() {
		
	}
	
		
	public Pessoa(String nome, String cpf, String email) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		counter += 1; 	 // aqui vai somar o contador 1 cada vez q o cliente criar uma conta
		
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
	// colocando as informações acima dentro do toString para apresentar esses dados depois
	
	public String toString() {
		return "\nNome: " + this.getNome() +
				"\nNome: " + this.getCpf() +
				"\nNome: " + this.getEmail(); 
		}
}
