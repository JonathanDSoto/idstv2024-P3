import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Pacman implements KeyListener{

	private JFrame frame;
	private JPanel panel_1;
	int x=200,y=200;

	Player jugador = new Player(200,200,30,30,"");

	Player walls[] = { new Player(350, 100, 20, 300,""),
						new Player(100, 100, 20, 300,"") };



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Pacman window = new Pacman();
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
	public Pacman() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 569);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.SOUTH);

		frame.addKeyListener(this);

		JButton btnNewButton = new JButton("Reiniciar");
		btnNewButton.setFocusable(false);
		panel.add(btnNewButton);

		panel_1 = new JPanel() {

			/**
			 * Esto es un panel con grphics rapido
			 */

			@Override
			   public void paintComponent(Graphics g) {
			      super.paintComponent(g);


			      g.setColor(Color.YELLOW);
			      g.fillOval(jugador.getX(), jugador.getY(), jugador.w, jugador.h);


			      for (Player obstaculo : walls) {
			    	  g.setColor(Color.WHITE);
				      g.fillRect(obstaculo.x, obstaculo.y, obstaculo.w, obstaculo.h);
			      }



			   }
		};

		panel_1.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);


	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		switch(e.getKeyCode()) {
			case 87://w
				jugador.y -= 10;
			break;
			case 83://s
				jugador.y += 10;
				break;
			case 68://d
				jugador.x += 10;
				break;
			case 65://a
				jugador.x -= 10;
				break;
		}


		panel_1.update(panel_1.getGraphics());

		for (Player obstaculo : walls) {
			if(jugador.seTocan(obstaculo)) {

				System.out.println("Se tocaron");
			}
		}



	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
