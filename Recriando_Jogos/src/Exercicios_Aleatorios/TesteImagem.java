package Exercicios_Aleatorios;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TesteImagem extends JFrame {

	ImageIcon imagem =new ImageIcon(getClass().getResource("sun.jpg"));
	JLabel label=new JLabel(imagem);
	
	
	public TesteImagem() {
		
		add(label);
		setSize(400,500);
		setTitle("Testando como colocar uma imagem");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		setVisible(true);
	}
	
	public static void main(String[]args) {
		new TesteImagem();
	}
	
	
}
