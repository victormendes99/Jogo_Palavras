import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	public static void main(String args[]) {
		try {
			
			ServerSocket server = new ServerSocket(1234);
			LogicaGame game = new LogicaGame();
			game.iniciaGame();
			System.out.println("Tema sorteado: " + game.getTema());
			System.out.println("Palavra sorteada: " + game.getPalavra());
			while(true) {
				System.out.println("Aguardando cliente");
				Socket cliente = server.accept();
				Scanner entrada = new Scanner(cliente.getInputStream());
				if(game.analisaResposta(entrada.nextLine())){
					System.out.println("Parabéns, vc acertou!");
					
				}
				else
					System.out.println("Tente novamente");
			}
			
		}
		catch(Exception ex) {
			System.out.println("Falha ao conectar com o cliente.");
		}
	}
	
}
