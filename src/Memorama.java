import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Memorama {

	private JFrame frame;
	ArrayList <Tarjeta> tarjetas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Memorama window = new Memorama();
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
	public Memorama() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 540);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		tarjetas = new ArrayList();
		int c = 1;

		for (int i = 0; i <8; i++) {
			tarjetas.add(new Tarjeta(c));

			tarjetas.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					Tarjeta link = (Tarjeta) e.getSource();

					link.girar();

					revisar();

				}});
			c++;
			if(c==5) {
				c=1;
			}
		}


		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(2, 4, 0, 0));


		for (int i = 0; i <8; i++) {

			panel_2.add(tarjetas.get(i));
		}



	}

	public int revisar()
	{
		int ide1=0,ide2=0,c = 0;
		for (Tarjeta tarjeta : tarjetas) {
			if(tarjeta.getEstado()==1) {
				if(ide1==0) {
					ide1 = tarjeta.getEdentificador();
				}else
					if(ide2==0) {
						ide2 = tarjeta.getEdentificador();
					}
				c++;
			}
		}

		if(ide1 == ide2 && ide1!=0 && ide2!=0){

			JOptionPane.showMessageDialog(frame, "No pares");

			return 1;
		}

		if(c == 2) {

			JOptionPane.showMessageDialog(frame, "No pares");

			regresar();
		}
		return 0;
	}

	public void regresar() {

		for (Tarjeta tarjeta : tarjetas) {

			if(tarjeta.getEstado()==1) {
				tarjeta.girar();
			}

		}
	}
}
