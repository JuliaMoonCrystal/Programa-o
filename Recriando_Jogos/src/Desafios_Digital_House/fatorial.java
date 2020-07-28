package Desafios_Digital_House;

public class fatorial {
	public static void main(String[] args) {
		int fatorial=5;
		System.out.println("O fatorial de "+fatorial+" é : "+CauculaFatorial(fatorial));
	}
	private static int CauculaFatorial(int fatorial) {
		int resultado=1;
		
		if(fatorial==0) {
			return fatorial;
		}
		else {
			for(int i=1;i<=fatorial;i++) {
				resultado*=i;
			}
		}
		
		return resultado;
	}
	
	
}
