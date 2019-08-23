import java.util.Random;
import java.lang.String;

public class LogicaGame {
	
	private  String[] pais = new String[]{"Alemanha","Brasil", "Portugal", "França", "Indonésia"};
	private  String[] time = new String[] {"Bahia", "São Paulo", "Ypiranga", "Flamengo"};
	
	public boolean analisaResposta(String resposta) {
		return true;
	}
	
	public String sorteiaTema() {
		Random random = new Random();
		int ran = random.nextInt(2);
		switch(ran) {
		case 0:
			return "País";
		case 1:
			return "Time";
		default:
			return "";
		}
	}
	
	public String sorteiaPalavra(String tema) {
		switch(tema){
		case "País":
			return "";
		default:
			return "";
		}
	}
	
}
