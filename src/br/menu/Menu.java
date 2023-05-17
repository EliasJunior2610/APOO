//Alunos: Denyel Fernando, Elias Sales, João Carlos, Luan Santos, Lucas Oliveira e Ricardo Junior.
//nome do pacote;
package br.menu;

//importações;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import br.repositorios.*;
import br.interfaces.*;
import br.servicos.*;
import br.entidades.*;

//inicializando a classe;
public class Menu {
	// método main;
	public static void main(String[] args) {
		// instanciando o Scanner e a classe BilheteRepositorio;
		Scanner ler = new Scanner(System.in);
		BilheteRepositorio repositorio = new BilheteRepositorio(new ArrayList<String>());
		// criando as variáveis;
		String x, b = "0";
		int quantidade= 0;
		double soma = 0;
		Connection connection = null;
		try {
    		// Configuração da conexão com o banco de dados
    		String url = "jdbc:mysql://localhost:3306/bilhetesonline";
    		String username = "root";
    		String password = "root";

    		// Estabelecendo a conexão
    		connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
    		e.printStackTrace();
		}

		
		// criando a estrutura de repetição para mostrar o menu;
		do {
			// menu;
			System.out.println("------------------------------");
			System.out.println("Se você deseja pedir bilhete insira qualquer valor, caso não, digite 1.");
			System.out.println("------------------------------");
			System.out.print("Resposta: ");
			// lendo a variável;
			x = ler.next();
			// saindo do menu, caso o usuário não queira comprar;
			if (x.equals("1")) {
				break;
				// escolhendo o tipo do bilhete, caso o usuário queira comprar;
			} else {
				System.out.println("------------------------------");
				System.out.println("Tipos de Bilhetes: Cinema, Passagem, Show e Teatro;");
				System.out.println("Digite 1 para pedir bilhete de cinema;");
				System.out.println("Digite 2 para pedir passagem;");
				System.out.println("Digite 3 para pedir bilhete de show;");
				System.out.println("Digite 4 para pedir bilhete de teatro;");
				System.out.println("------------------------------");
				System.out.print("Resposta: ");
				// lendo o tipo de bilhete
				b = ler.next();

				// comprando bilhetes de cinema;
				if (b.equals("1")) {
					repositorio.addBilheteRepositorio("Bilhete de Cinema");
					ArrayList<String> bilhetes = repositorio.getBilheteRepositorio();
					System.out.printf("Você escolheu comprar %s \n", bilhetes);
					System.out.println("------------------------------");
					System.out.print("Quantos bilhetes você deseja: ");
					quantidade = ler.nextInt();
					System.out.println("------------------------------");
					BilheteDeCinema b1 = new BilheteDeCinema(2.30, 30 * quantidade, quantidade,"A32");
					System.out.println("Você pediu " + b1.quantidade + " bilhetes.");
					soma = soma + b1.preço;
					System.out.println("O valor total é igual a R$" + soma);
					try {
						// Preparando a instrução SQL para inserção dos dados
						String sql = "INSERT INTO bilhetes_de_cinema (tipo, quantidade, preco) VALUES (?, ?, ?)";
						PreparedStatement statement = connection.prepareStatement(sql);
						statement.setString(1, b);
						statement.setInt(2, quantidade);
						statement.setDouble(3, soma);
					
						// Executando a instrução SQL
						int rowsInserted = statement.executeUpdate();
						if (rowsInserted > 0) {
							System.out.println("Dados do bilhete inseridos no banco de dados.");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

					// comprando passagens;
				} else if (b.equals("2")) {
					repositorio.addBilheteRepositorio("Passagem");
					ArrayList<String> bilhetes = repositorio.getBilheteRepositorio();
					System.out.printf("Você escolheu comprar %s \n", bilhetes);
					System.out.println("------------------------------");
					System.out.print("Quantos bilhetes você deseja: ");
					quantidade = ler.nextInt();
					System.out.println("------------------------------");
					Passagem f1 = new Passagem(2.30, 20 * quantidade, quantidade, "B14");
					System.out.println("Você pediu " + f1.quantidade + " bilhetes.");
					soma = soma + f1.preço;
					System.out.println("O valor total é igual a R$" + soma);
					try {
						// Preparando a instrução SQL para inserção dos dados
						String sql = "INSERT INTO passagem (tipo, quantidade, preco) VALUES (?, ?, ?)";
						PreparedStatement statement = connection.prepareStatement(sql);
						statement.setString(1, b);
						statement.setInt(2, quantidade);
						statement.setDouble(3, soma);
					
						// Executando a instrução SQL
						int rowsInserted = statement.executeUpdate();
						if (rowsInserted > 0) {
							System.out.println("Dados do bilhete inseridos no banco de dados.");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

					// comprando bilhetes de show;
				} else if (b.equals("3")) {
					repositorio.addBilheteRepositorio("Bilhete de Show");
					ArrayList<String> bilhetes = repositorio.getBilheteRepositorio();
					System.out.printf("Você escolheu comprar %s \n", bilhetes);
					System.out.println("------------------------------");
					System.out.print("Quantos bilhetes você deseja: ");
					quantidade = ler.nextInt();
					System.out.println("------------------------------");
					BilheteDeShow s1 = new BilheteDeShow(2.30, 90 * quantidade, quantidade);
					System.out.println("Você pediu " + s1.quantidade + " bilhetes.");
					soma = soma + s1.preço;
					System.out.println("O valor total é igual a R$" + soma);
					try {
						// Preparando a instrução SQL para inserção dos dados
						String sql = "INSERT INTO bilhetes_de_show (tipo, quantidade, preco) VALUES (?, ?, ?)";
						PreparedStatement statement = connection.prepareStatement(sql);
						statement.setString(1, b);
						statement.setInt(2, quantidade);
						statement.setDouble(3, soma);
					
						// Executando a instrução SQL
						int rowsInserted = statement.executeUpdate();
						if (rowsInserted > 0) {
							System.out.println("Dados do bilhete inseridos no banco de dados.");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

					// comprando bilhetes de teatro;
				} else if (b.equals("4")) {
					repositorio.addBilheteRepositorio("Bilhete de Teatro");
					ArrayList<String> bilhetes = repositorio.getBilheteRepositorio();
					System.out.printf("Você escolheu comprar %s \n", bilhetes);
					System.out.println("------------------------------");
					System.out.print("Quantos bilhetes você deseja: ");
					quantidade = ler.nextInt();
					System.out.println("------------------------------");
					BilheteDeTeatro t1 = new BilheteDeTeatro(2.30, 15 * quantidade, quantidade);
					System.out.println("Você pediu " + t1.quantidade + " bilhetes.");
					soma = soma + t1.preço;
					System.out.println("O valor total é igual a R$" + soma);
					try {
						// Preparando a instrução SQL para inserção dos dados
						String sql = "INSERT INTO bilhetes_de_teatro (tipo, quantidade, preco) VALUES (?, ?, ?)";
						PreparedStatement statement = connection.prepareStatement(sql);
						statement.setString(1, b);
						statement.setInt(2, quantidade);
						statement.setDouble(3, soma);
					
						// Executando a instrução SQL
						int rowsInserted = statement.executeUpdate();
						if (rowsInserted > 0) {
							System.out.println("Dados do bilhete inseridos no banco de dados.");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

					// caso o usuário escolha uma opção inválida;
				} else {
					System.out.println("Erro! Opção inválida!");
					System.out.println("Por favor, insira um dos valores indicados.");
				}
			}
			// fim da estrutura de repetição;
		} while (x != "1");
		ler.close();
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}