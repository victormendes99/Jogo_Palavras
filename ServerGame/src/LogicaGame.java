import java.util.Random;
import java.lang.String;

public class LogicaGame {
	
	private  String[] pais = new String[]{"Alemanha","Brasil", "Portugal", "França", "Indonésia"};
	private  String[] time = new String[] {"Bahia", "São Paulo", "Ypiranga", "Flamengo"};
	
	private String tema;
	private String palavra;
	
	public String getTema() {
		return tema;
	}
	
	public String getPalavra() {
		return palavra;
	}
	
	public void iniciaGame() {
		tema = sorteiaTema();
		palavra = sorteiaPalavra(tema);
	}
	
	public boolean analisaResposta(String resposta) {
		return (palavra.equals(resposta));
	}
	
	public String sorteiaTema() {
		
		switch(randon(2)) {
		case 0:
			return "País";
		case 1:
			return "Time";
		default:
			return "";
		}
	}
	
	private int randon(int range) {
		Random random = new Random();
		return random.nextInt(range);
	}
	
	public String sorteiaPalavra(String tema) {
		switch(tema){
		case "País":
			return this.pais[randon(this.pais.length)];
		case "Time":
			return this.time[randon(this.time.length)];
		default:
			return "";
		}
	}
	
}
