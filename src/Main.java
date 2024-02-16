import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame ventana = new JFrame();
		
		//visible 
		ventana.setVisible(true);
		
		//que hará el programa cuando cierre la ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//tamaño
		ventana.setSize(500,500);
		
		//centrar
		ventana.setLocationRelativeTo(null);
		
		//ventana.setLocation(100, 100);
		
		ventana.setTitle("Mi ventanita");
		
		ventana.setResizable(true); 
		
		ventana.setMinimumSize(new Dimension(200,200));
		
	}

}
