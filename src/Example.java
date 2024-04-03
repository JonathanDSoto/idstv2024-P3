import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

public class Example {

	private JFrame frame; 
	public int tablero[][] = {{1,2,3,4},{1,2,3,4}};
	public int status[][] = {{0,0,0,0},{0,0,0,0}};
	JPanel panel_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Example window = new Example();
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
	public Example() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		//desordenar
		
		frame = new JFrame();
		frame.setBounds(100, 100, 563, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(97, 255, 46));
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 127, 31));
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_8 = new JButton("Reiniciar");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				reset();
				
			}
		});
		panel_2.add(btnNewButton_8);
		
		panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(2, 4, 0, 0));
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				girar(0,0,btnNewButton_2);
			}
		});
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				girar(0,1,btnNewButton_7);
			}
		});
		panel_3.add(btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				girar(0,2,btnNewButton_6);
			}
		});
		panel_3.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				girar(0,3,btnNewButton_5);
				
			}
		});
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("New button");
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				girar(1,0,btnNewButton_4);
			}
		});
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				girar(1,1,btnNewButton_3);
			}
		});
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				girar(1,2,btnNewButton_1);
			}
		});
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				girar(1,3,btnNewButton);
			}
		});
		panel_3.add(btnNewButton);
	}
	
	public void girar(int x,int y, JButton btn) { 
		
		int a = 0;
		int b = 0;
		btn.setText(tablero[x][y]+"");
		
		btn.setIcon(new ImageIcon(getClass().getResource(tablero[x][y]+".png")));
		
		status[x][y] = 1;
		btn.setEnabled(false);
		int tarjetas = 0;
		
		for(int i = 0; i<2; i++) {
			for(int j = 0; j<4; j++) {
				
				if(status[i][j]==1) {
					tarjetas++;
				}
				
			}
		}
		if(tarjetas == 2) {
			
			System.out.println("Verificar pares");
			
			for(int i = 0; i<2; i++) {
				for(int j = 0; j<4; j++) {
					
					if(status[i][j]==1) {
						if(a==0) { 
							a = tablero[i][j];
						}else if(b==0) {
							b = tablero[i][j];
						} 
							
					}
					
				}
			}
			
			if(a == b && a!=0) {
				
				JOptionPane.showMessageDialog(panel_3,
					    "Pares");
				
				for(int i = 0; i<2; i++) {
					for(int j = 0; j<4; j++) {
						
						if(status[i][j]==1) {
							status[i][j] = 2; 
						}
						
					}
				}
				
				a = 0;
				b = 0;
				
			}else {
				
				
				JOptionPane.showMessageDialog(panel_3,
					    "No pares"); 
				
				
				Component arreglo[] = panel_3.getComponents();
				for (int i = 0; i < arreglo.length; i++) { 
					
					//if(arreglo[i].getClass().toString().equals("class javax.swing.JButton")) {
						
					JButton link = (JButton) arreglo[i]; 
					
					if(link.getText().equals(a+"") || link.getText().equals(b+"")) {
						
						System.out.println("hola");
						link.setText("");
						link.setEnabled(true);
						link.setIcon(null);
						//cambiar icono
					}
						 
						 
					//}
					
				}
				
				for(int i = 0; i<2; i++) {
					for(int j = 0; j<4; j++) {
						
						if(status[i][j]==1) {
							status[i][j] = 0; 
						}
						
					}
				}
				
			}
		}
		
	}
	
	public void reset()
	{ 
		
		for(int i = 0; i<2; i++) {
			for(int j = 0; j<4; j++) {
				
				status[i][j] = 0; 
				
			}
		}
		
		Component arreglo[] = panel_3.getComponents();
		for (int i = 0; i < arreglo.length; i++) { 
			 
			JButton link = (JButton) arreglo[i];  
			
			link.setText("");
			link.setEnabled(true);
			
		}
	}
}
