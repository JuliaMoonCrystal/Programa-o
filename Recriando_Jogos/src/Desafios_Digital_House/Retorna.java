package Desafios_Digital_House;

public class Retorna {
	public static void main(String[] args) {
		int [] array= {1,2,-3,-9,6-0,0,4};
		System.out.println(" "+maisMenos(array));
		
	}

	private static int[] maisMenos(int[] array) {
		int quantidade=array.length;
		int positivos=0;
		int negativos=0;
		int zeros=0;
		for(int i=0;i<array.length;i++) {
			if(array[i] <0 ) {
				zeros+=1;
			}
			else if(array[i] >0) {
				positivos+=1;
			}
			else {
				zeros+=1;
			}
		}
		positivos=positivos/quantidade;
		negativos=negativos/quantidade;
		zeros=zeros/2;
		
		int [] NovoArray={positivos,zeros,negativos};
		
		
		return NovoArray;
	}
}
