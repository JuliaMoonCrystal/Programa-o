package Trabalhando_Listas;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class Tela_Principal implements ActionListener {
	public static void main(String [] args) {
		JFrame janela= new JFrame(); //Criamos a instancia do jframe;
		
		//Criamos os botões
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
		
		
	  //adicionamos ações para os botões
		adicionar.addActionListener(new ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
			   if(e.getSource()==adicionar) {
				   System.out.println("Botão adicionar acionado");
			   }
			}
		});
		
		excluir.addActionListener(new ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
			   if(e.getSource()==excluir) {
				   System.out.println("Botão excluir acionado");
			   }
			}
		});
		
		Pesquisar.addActionListener(new ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
			   if(e.getSource()==Pesquisar) {
				   System.out.println("Botão Pesquisar acionado");
			   }
			}
		});
		
		atualizar.addActionListener(new ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
			   if(e.getSource()==atualizar) {
				   System.out.println("Botão Atualizar acionado");
			   }
			}
		});
		
        janela.setTitle("Agenda de Contatos");			
		janela.setSize(500,500);
		janela.setLayout(null);
		janela.setVisible(true);
	
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
