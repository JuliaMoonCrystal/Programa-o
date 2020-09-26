package Trabalhando_Listas;

import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Tela_Principal implements ActionListener {
	public static void main(String [] args) {
		JFrame janela= new JFrame(); //Criamos a instancia do jframe;
		LinkedList<Contato> contato= new LinkedList<>();
		
		
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
				   
				   JFrame add= new JFrame();
				   JLabel nome= new JLabel("Nome do Contato:");
				   JTextField text_nome= new JTextField();
				   
				   nome.setBounds(10, 50,50,50);
				   text_nome.setBounds(150,50,100,40);
				   add.add(nome);
				   add.add(text_nome);
				   
				   
				    
			        add.setTitle("Agenda de Contatos");			
					add.setSize(500,500);
					add.setLayout(null);
   				    add.setVisible(true);
   				    
   				    
   				    
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
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
