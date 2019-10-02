package negocio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class LogicaGame implements Runnable {

	private String[] pais = new String[] { "Alemanha", "Brasil", "Portugal", "França", "Indonésia", "Bolivia", "Peru",
			"Japão", "EUA", "Rússia", "Argentina" };

	private String[] time = new String[] { "Bahia", "São Paulo", "Ypiranga", "Flamengo", "Vitoria", "Vasco", "Sport",
			"Curitiba", "Cruzeiro" };

	private String[] carro = new String[] { "Gol", "Fusca", "Ferrari", "Focus", "Ranger", "Masseratti", "Lamborghini",
			"Mustang", "Hb20", "Amarok" };

	private String[] frutas = new String[] { "Abacaxi", "Uva", "Melão", "Melancia", "Banana", "Caju", "Umbu", "Manga",
			"Carambola", "Acerola" };
	
	private String[] profissoes = new String[] { "Professor", "Administrador", "Bombeiro", "Policial", "Engenheiro", "Medico", "Gari", "Servente",
			"Programador", "Pedreiro" };

	private String[] burrice = new String[] { "Burrão vei...", "Você é parente de jumento?",
			"Certeza que é torcedor do vitoria!", "Num vai acertar nunca pai...", "Se errar tudo vai tomar pau..." };

	private String tema;
	private String palavra;
	private int tentativas;
	private Socket client;

	public LogicaGame(Socket client) {
		this.client = client;
		tentativas = 10;
		iniciaGame();
	}

	public void iniciaGame() {
		tema = sorteiaTema();
		palavra = sorteiaPalavra(tema);
	}

	@Override
	public void run() {
		try {
			Scanner in = new Scanner(this.client.getInputStream());
			PrintWriter out = new PrintWriter(this.client.getOutputStream(), true);
			out.println("O tema sorteado foi " + tema + " , se vire pra advinhar mermão...");
			while (tentativas > 0) {
				boolean acertou = this.analisaResposta(in.nextLine());
				if (acertou) {
					out.println("Voce ganhou");
					break;
				} else
					out.println(burrice[randon(burrice.length - 1)] + " voce tem " + --tentativas + " tentativas.");

			}
			if (tentativas == 0) {
				out.println("Voce perdeu");
				in.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean analisaResposta(String resposta) {
		return (palavra.equalsIgnoreCase(resposta));
	}

	private String sorteiaTema() {

		switch (randon(5)) {
		case 0:
			return "Países";
		case 1:
			return "Times";
		case 2:
			return "Carros";
		case 3:
			return "Frutas";
		case 4:
			return "Profissoes";
		default:
			return "";
		}
	}

	private int randon(int range) {
		Random random = new Random();
		return random.nextInt(range);
	}

	public String sorteiaPalavra(String tema) {
		switch (tema) {
		case "Países":
			return this.pais[randon(this.pais.length)];
		case "Times":
			return this.time[randon(this.time.length)];
		case "Carros":
			return this.carro[randon(this.carro.length)];
		case "Frutas":
			return this.frutas[randon(this.frutas.length)];
		case "Profissoes":
			return this.profissoes[randon(this.profissoes.length)];
			
		default:
			return "";
		}
	}

}
