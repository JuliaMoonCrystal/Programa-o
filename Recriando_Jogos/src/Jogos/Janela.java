package Jogos;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame {
	private JPanel tela;
	
	
	public Janela() {
		 tela= new JPanel() {
		 
		 public void paintComponent(Graphics g) {
			// A pintura vai ocorrer aqui
			 g.setColor(Color.BLUE);
			 g.drawLine(100, 240, 640, 240);
			 g.drawRect(10, 25, 20, 20);
			 g.drawOval(30, 20, 40, 30);
			 g.setColor(Color.YELLOW);
			 g.drawLine(320, 0, 320, 480);
			 g.fillRect(110, 125, 120, 120);
			 g.fillOval(230, 220, 240, 230);
			 g.setColor(Color.RED);
			 g.drawString("seria um ótimo Score!", 10, 10);
			 
			}
		 };
		super.getContentPane().add(tela);
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Jogo da Cobrinha");
		setSize(640, 480);
		setVisible(true);
		
		}
		public static void main(String[] args) {
		//new Janela();
			AnimacaoTela anima = new AnimacaoTela();
			anima.iniciaAnimacao();
		}
}
   

