import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//import org.json.JSONObject;
//import org.json.JSONTokener;

//import java.io.FileWriter;
//import java.io.IOException; 

public class Sistema {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Sistema window = new Sistema();
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
	public Sistema() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JSONParser parser = new JSONParser();
		
		try {
            Object obj = parser.parse(new FileReader("/Users/joanthansoto/eclipse-workspace/ExampleTV/src/users.json"));
             
            JSONObject jsonObject = (JSONObject) obj;
             
            JSONArray companyList = (JSONArray) jsonObject.get("users");
             
            Iterator<JSONObject> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next().get("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  

		frame = new JFrame();
		frame.setBounds(100, 100, 371, 482);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		this.recover(frame);

		JMenuBar barra = new JMenuBar();

		JMenu users_menu = new JMenu("Cuenta");
		barra.add(users_menu);

		JMenuItem login = new JMenuItem("Login");
		users_menu.add(login);
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();

				login(frame);
			}

		});

		JMenuItem registro = new JMenuItem("Registro");
		users_menu.add(registro);
		registro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();

				registro(frame);
			}

		});

		JMenuItem recover = new JMenuItem("Recuperación de cuenta");
		users_menu.add(recover);
		recover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();

				recover(frame);
			}

		});


		frame.setJMenuBar(barra);

	}

	public void login(JFrame frame) {

		JPanel panel = new JPanel();
		panel.setBackground(new Color(180, 188, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Iniciar sesión");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(69, 42, 210, 44);
		panel.add(lblNewLabel);

		JTextField textField = new JTextField();
		textField.setBounds(81, 126, 210, 44);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Correo electrónico");
		lblNewLabel_1.setForeground(new Color(234, 252, 255));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(84, 110, 200, 16);
		panel.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Acceder");

		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(81, 314, 210, 44);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Crear cuenta");
		btnNewButton_1.setBounds(81, 390, 210, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				frame.getContentPane().remove(panel);
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();

				registro(frame);
			}
		});
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setForeground(new Color(234, 252, 255));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(84, 213, 200, 16);
		panel.add(lblNewLabel_1_1);

		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(81, 229, 210, 44);
		panel.add(textField_1);
	}

	public void registro(JFrame frame) {

		JPanel panel = new JPanel();
		panel.setBackground(new Color(180, 188, 255));

		frame.getContentPane().add(panel, BorderLayout.CENTER);

		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Crear cuenta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(69, 42, 210, 44);
		panel.add(lblNewLabel);

		JTextField textField = new JTextField();
		textField.setBounds(81, 126, 210, 44);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Correo electrónico");
		lblNewLabel_1.setForeground(new Color(234, 252, 255));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(84, 110, 200, 16);
		panel.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Registarme");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(81, 334, 210, 44);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Regrear al login");
		btnNewButton_1.setBounds(81, 390, 210, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				frame.getContentPane().remove(panel);
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();

				login(frame);
			}
		});
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setForeground(new Color(234, 252, 255));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(84, 182, 200, 16);
		panel.add(lblNewLabel_1_1);

		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(81, 198, 210, 44);
		panel.add(textField_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setForeground(new Color(234, 252, 255));
		lblNewLabel_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1.setBounds(84, 254, 200, 16);
		panel.add(lblNewLabel_1_1_1);

		JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(81, 270, 210, 44);
		panel.add(textField_2);
	}

	public void recover(JFrame frame) {

		JPanel panel = new JPanel();
		panel.setBackground(new Color(180, 188, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Recuperación");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(69, 42, 210, 44);
		panel.add(lblNewLabel);
	}
}
