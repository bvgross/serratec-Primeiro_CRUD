package teste;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class teste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conexao = null;


		try {
			String url = "jdbc:postgresql://localhost:5432/testeapp";
			String usuario = "app";
			String senha = "1234";

			// 1. Conexão com banco SQLite
			conexao = DriverManager.getConnection(url, usuario, senha);

			// 2. Criar tabela se não existir
			String criarTabela = "CREATE TABLE IF NOT EXISTS primeiro.tabela1 ("
					+ "id SERIAL PRIMARY KEY,"
					+ "nome VARCHAR(100))";
			Statement stmt = conexao.createStatement();
			stmt.execute(criarTabela);

			// 3. Menu CRUD

			int opcao;
			do { 
				System.out.println("\n1 - Adicionar");
				System.out.println("2 - Listar");
				System.out.println("3 - Atualizar");
				System.out.println("4 - Deletar");
				System.out.println("0 - Sair");
				System.out.print("Escolha: ");

				opcao = sc.nextInt();

				sc.nextLine();

				switch (opcao) {

				case 1:
					System.out.println("Nome: ");
					String nome = sc.nextLine();
					PreparedStatement insert = conexao.prepareStatement("INSERT INTO primeiro.tabela1 (nome) VALUES (?)");
					insert.setString(1, nome);
					insert.executeUpdate();
					insert.close();
					System.out.println("Usuário adicionado!");
					break; 

				case 2: 
					ResultSet rs = stmt.executeQuery("SELECT * FROM primeiro.tabela1");
					while(rs.next()) {
						System.out.println("ID: " + rs.getInt("id") + " |Nome: " + rs.getString("nome"));
					}
					rs.close();
					break;

				case 3:
					System.out.println("ID do usuário a atualizar: ");
					int idAtualizar = sc.nextInt();
					sc.nextLine();
					System.out.println("Novo nome: ");
					String novoNome = sc.nextLine();
					PreparedStatement update = conexao.prepareStatement("UPDATE primeiro.tabela1 SET nome = ? WHERE id = ?");
					update.setString(1, novoNome);
					update.setInt(2, idAtualizar);
					update.executeUpdate();
					update.close();
					System.out.println("Usuário atualizado com sucesso.");
					break;

				case 4: 
					System.out.println("ID do usuário a deletar: ");
					int idDeletar = sc.nextInt();
					sc.nextLine();
					PreparedStatement delete = conexao.prepareStatement("DELETE FROM primeiro.tabela1 WHERE id = ?");
					delete.setInt(1, idDeletar);
					delete.executeUpdate();
					delete.close();
					System.out.println("Usuário deletado com sucesso.");
					break;

				case 0:
					System.out.println("Encerrando a aplicação.");
					break;

				default:
					System.out.println("Opção inválida.");

				}
			} while (opcao != 0);
			stmt.close();
			conexao.close();
			sc.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
