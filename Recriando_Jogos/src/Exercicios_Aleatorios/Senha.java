package Exercicios_Aleatorios;

import javax.swing.JOptionPane;



// esse c�digo vai  receber uma senha e 2 numeros ,depois vai confirmar a senha se a senha for
//igual ent�o vai mostrar a divis�o do 1 numero pelo segundo,se n�o for igual vai mostar uma mensagem de senha incorreta//

public class Senha {

	public static void main(String[] args) {
		String CadastroSenha="";
		String ConfirmaSenha="";
		double a=0;
		double b=0;
		
		CadastroSenha=JOptionPane.showInputDialog(null," Digite a sua Senha :");
		
		a=Double.parseDouble(JOptionPane.showInputDialog("Digite um numero:"));
		b=Double.parseDouble(JOptionPane.showInputDialog("Digite um numero:"));
		
		ConfirmaSenha=JOptionPane.showInputDialog(null," Confirme a sua Senha :");
		
		if(CadastroSenha.equals(ConfirmaSenha)) {
			System.out.println("O resultado da divis�o: "+(a/b));
		}
		else {
			System.out.println("Senha incorreta");
		}
	    System.exit(0);	
	}

}
