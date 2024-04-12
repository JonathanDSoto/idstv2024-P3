import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random; 

import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Teclado implements KeyListener{

	private JFrame frame;
	Random rand = new Random();
	String[] palabras = {"perro", "gato", "casa", "arbol", "coche", "computadora", "cacahuate"};
	int palabra_objetivo  = 0;
	JLabel lblNewLabel;
	JLabel lblNewLabel_3; 
	static int t;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teclado window = new Teclado();
					window.frame.setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Teclado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.addKeyListener(this);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBackground(new Color(8, 255, 151));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(18, 6, 331, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1.1");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(new Color(164, 255, 95));
		lblNewLabel_1.setBounds(361, 6, 83, 34);
		lblNewLabel_1.setOpaque(true);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("Palabra: ");
		lblNewLabel_3.setBounds(18, 52, 331, 16);
		panel.add(lblNewLabel_3);
		
		String letras [] =  { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " "}; 
		
		int x = 21, y = 82, c= 0;
		
		for (int i = 0; i < letras.length; i++) { 
			
			JLabel lblNewLabel_2 = new JLabel(letras[i]);
			lblNewLabel_2.setBackground(new Color(0, 0, 0));
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setForeground(new Color(225, 255, 221));
			lblNewLabel_2.setBounds(x, y, 61, 63);
			lblNewLabel_2.setOpaque(true);
			panel.add(lblNewLabel_2);
			
			x+= 61+10;
			c++;
			if(c==6) { c=0; x=21; y += 63+10; }
			
		} 
		
		palabra_objetivo = rand.nextInt(palabras.length); 
		lblNewLabel_3.setText("Palabra:" + palabras[palabra_objetivo].toUpperCase());
		
		//Thread timeThread = new Thread(new Teclado());
		//timeThread.start();
		//run();
		
		t = 0;
		Timer timer = new Timer (100, new ActionListener ()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		         t += 100;
		         lblNewLabel_1.setText(t+"");
		     }
		});
		
		timer.start();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub 
		
		String target = e.getKeyChar()+"";
		target = target.toUpperCase();
		
		Component componentes[] = frame.getContentPane().getComponents();
		
		for (int i = 0; i < componentes.length; i++) { 
			
			JPanel panel = (JPanel) componentes[i]; 
			Component otros[] = panel.getComponents();
			
			for (int j = 0; j < otros.length; j++) { 
				
				if(otros[j].getClass().toString().equals("class javax.swing.JLabel")) {
					
					JLabel link = (JLabel) otros[j];  
					link.setBackground(Color.black);
					
					if(link.getText().equals(target)) {
						int nextInt = rand.nextInt(0xffffff + 1);  
				        String colorCode = String.format("#%06x", nextInt); 
				        link.setBackground(Color.decode(colorCode));
				        
				        lblNewLabel.setText( lblNewLabel.getText()+link.getText() );
				        
				        if( palabras[palabra_objetivo].toUpperCase().equals(lblNewLabel.getText()) ) {
				        	
				        	JOptionPane.showMessageDialog(frame, "alert", "alert", JOptionPane.ERROR_MESSAGE);
				        	
				        	lblNewLabel.setText("");
				        	palabra_objetivo = rand.nextInt(palabras.length);
				        	lblNewLabel_3.setText("Palabra:" + palabras[palabra_objetivo].toUpperCase());
				        	
				        	frame.repaint();
				        	frame.revalidate();
				        } 
				        
				        if( palabras[palabra_objetivo].length() <= lblNewLabel.getText().length()) {
				        	JOptionPane.showMessageDialog(frame, "alert", "alert", JOptionPane.ERROR_MESSAGE);
				        	
				        	lblNewLabel.setText("");
				        	palabra_objetivo = rand.nextInt(palabras.length);
				        	lblNewLabel_3.setText("Palabra:" + palabras[palabra_objetivo].toUpperCase());
				        	
				        	frame.repaint();
				        	frame.revalidate();
				        }
					}
					
					
					 
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

class TimeCounter implements Runnable {
    public void run() {
        long startTime = System.currentTimeMillis();
        while (true) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = (currentTime - startTime) / 100; // Convertimos a segundos
            System.out.println("Tiempo transcurrido: " + elapsedTime + " milisegundos");
            try {
                Thread.sleep(100); // Esperamos 1 segundo antes de mostrar el siguiente segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
