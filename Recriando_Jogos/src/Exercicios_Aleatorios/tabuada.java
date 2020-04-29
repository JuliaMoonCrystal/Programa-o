package Exercicios_Aleatorios;

import java.util.zip.InflaterInputStream;

import javax.swing.JOptionPane;

public class tabuada {
	public static void main(String[] args) {
		int cont =0;
		int numero=Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
		while(cont <=10) {
		  int var=numero*cont;
		  cont++;
		  System.out.println("A multiplicação do numero "+numero+" por "+cont+" é "+var);
		}
		
	}
}
