package Trabalhando_Listas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tela_Principal {
	public static void main(String [] args) {
		JFrame janela= new JFrame(); //Criamos a instancia do jframe;
		
		JButton adicionar= new JButton("Adicionar novo contato");
		JButton excluir= new JButton("Excluir contato");
		JButton Pesquisar= new JButton("Pesquisar contato");
		JButton atualizar= new JButton("Atualizar contato");
		
		
		adicionar.setBounds( 150 , 100 , 190 ,  40 );
		excluir.setBounds(150 , 150 , 190 ,  40 );
		Pesquisar.setBounds(150 , 200 , 190 ,  40 );
		atualizar.setBounds(150 , 250 , 190 ,  40 );
		
		//Aqui adicionamos os botões na tela 
		janela.add(adicionar);
		janela.add(excluir);
		janela.add(Pesquisar);
		janela.add(atualizar);
		
        janela.setTitle("Agenda de Contatos");			
		janela.setSize(500,500);
		janela.setLayout(null);
		janela.setVisible(true);
	
	}
}
