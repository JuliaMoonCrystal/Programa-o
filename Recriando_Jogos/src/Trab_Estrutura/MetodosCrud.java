package Trab_Estrutura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class MetodosCrud {
	
	public LinkedList<dados> Create(LinkedList<dados> dados_lista) throws IOException {
		
		//Aqui tem a criação do arquivo //
		  String fileName = "Entrada.txt";
		  BufferedWriter writer = new BufferedWriter(new FileWriter( fileName ));
		
		//aqui pergunta ao usauario quantos novos dados ele ira adicionar na lista//
		  int novo_elemento=Integer.parseInt(JOptionPane.showInputDialog("Qantos novos dados você quer adicionar na lista ?"));
		  
		//aqui existe um laço para o usuario digitar as variaveis//  
		 for(int i=0;i<novo_elemento;i++){
			 String nova_regiao=JOptionPane.showInputDialog("Digite uma Região de São Paulo :");
			 int novo_indice=Integer.parseInt(JOptionPane.showInputDialog("Digite o indice de poluição :"));
			 String nova_qualidade=JOptionPane.showInputDialog("Digite a qualidade do ar :");
			 
			 dados_lista.add(new dados(nova_regiao,novo_indice,nova_qualidade));
		 }
		
		// ADICIONA ALGUNS ELEMENTOS NA LinkedList// 
		 dados_lista.add(new dados("São Paulo",30,"N1-Boa"));
		 dados_lista.add(new dados("Rio de Janeiro",40,"N1-Boa"));
		 dados_lista.add(new dados("Baia",10,"N1-Boa"));
		 dados_lista.add(new dados("Piaui",80,"N2-Moderada"));
		 dados_lista.add(new dados("Rio Grande do Sul",60,"N2-Moderada"));      
		
        //Grava os dados no Arquivo//  
        for(dados dado : dados_lista){
        	  System.out.println("Aqui a lista : "+dado.getRegiao()+"com indice de: "+dado.getDados_Regiao()+"de poluição  Qualidade do ar: "+dado.getQualidade()+"\n");	
        	  writer.write("Região : "+ dado.getRegiao()+" possui um nivel de : "+dado.getDados_Regiao()+" de poluição  Qualidade do Ar : "+dado.getQualidade()+"\n");  	
        	  writer.newLine();	
        }         
        writer.close();
		return dados_lista;
		
	}

	public void Read(LinkedList<dados> dados_lista) throws IOException {
		
	//AQUI PEGA O NOME DO ARQUIVO PARA PODER FAZER A LEITURA //	
		 String fileName = "Entrada.txt";
		 BufferedReader ler = new BufferedReader(new FileReader( fileName ));
         String line = ""; 
     
   //AQUI VAI LER LINHA POR LINHA DO ARQUIVO E MOSTRAR NO CONSOLE//
         System.out.println(" \n\n Aqui os dados que tem no arquivo :");
         while (true) {
             if (line != null) {
                System.out.println(line);
             } else
                 break;
             line = ler.readLine();
         }
         ler.close();
	}

	public LinkedList<dados> Update(LinkedList<dados> dados_lista) {
        
       
		
		
		
		return null;
	}

	public void Delete(LinkedList<dados> dados_lista) throws IOException {
		
		 String fileName = "Entrada.txt";
		 BufferedReader ler = new BufferedReader(new FileReader( fileName ));
         String line = ""; 
		
		 while (true) {
             if (line != null) {
              //  System.out.println(line);
             } else
                 break;
             line = ler.readLine();
             
         }
         ler.close();		
		
		
	}

	public void Pesquisa(LinkedList<dados> dados_lista) {
		// TODO Auto-generated method stub
		
	}
  
}
