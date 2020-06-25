package Trab_Estrutura;

import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Principal {
   public static void main(String [] args) throws IOException{
	  //Nesta Classe vai apresentar todas as opções que o usuario pode fazer//
	  int opc=0;
	  LinkedList<dados> dados_lista= new LinkedList<>();
	  
	  do{
		  opc = Integer.parseInt(JOptionPane.showInputDialog("-----------Dados Ambientais----------- \n1 -Create Dados- "
		  		+ "\n2 -Read- \n3 -Update- \n4 -Delete- \n5 -Ordena por quickSort-  \n6 -Ordena por BubbleSort- \n7 Pesquisa na lista"
		  		+ " \n8 -Finalizar Consulta "));
           MetodosCrud metodos =new MetodosCrud();
           Ordenacao ordena=new Ordenacao();
            switch (opc)
            {
                  case 1: dados_lista =metodos.Create(dados_lista);
                             break;
                  case 2: metodos.Read(dados_lista);
                             break;
                  case 3: dados_lista=metodos.Update(dados_lista);
                             break;
                  case 4: metodos.Delete(dados_lista);
                             break;
                  case 5: ordena.Ordena_Quick(dados_lista);
                             break;
                  case 6: ordena.Ordena_Bubble(dados_lista);
                             break;
                  case 7: metodos.Pesquisa(dados_lista);
                              break;
                             
                  case 8: JOptionPane.showMessageDialog(null,"---FIM---");
                             break;             
                  default: JOptionPane.showMessageDialog(null,"opc inválida");
            }
        }
      while(opc != 5);
     }  
   }

