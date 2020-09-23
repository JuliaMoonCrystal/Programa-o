package Trabalhando_Listas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tela_Principal {
	public static void main(String [] args) {
		JFrame janela= new JFrame(); //Criamos a instancia do jframe;
		
		JButton adicionar= new JButton("Adicionar novo contato");
		//JButton excluir= new JButton("Excluir contato");
	//	JButton Pesquisar= new JButton("Pesquisar contato");
	//	JButton atualizar= new JButton("Atualizar contato");
		
		
		adicionar.setBounds( 130 , 100 , 190 ,  40 );
		//excluir.setBounds(190 , 100 , 190 ,  40 );
		//Pesquisar.setBounds(130 , 100 , 190 ,  40 );
		//atualizar.setBounds(130 , 100 , 190 ,  40 );
		
		
		janela.add(adicionar);
		//janela.add(excluir);
        janela.setTitle("Janela Principal");			
		janela.setSize(500,500);
		janela.setLayout(null);
		janela.setVisible(true);
	
	}
}
