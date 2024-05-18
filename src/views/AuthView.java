package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controllers.AuthController;
import models.AuthModel;

public class AuthView {
	
	private JFrame frame;
	private AuthModel functions; 
	private AuthController controller;
	
	public AuthView() {
		
		frame = new JFrame();
		frame.setVisible(false);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		functions = new AuthModel();
	}
	
	
	public void register() {
		
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(180, 188, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Crear una cuenta");
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
		
		

		JButton btnNewButton_1 = new JButton("Acceder");
		btnNewButton_1.setBounds(81, 390, 210, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				/*frame.getContentPane().remove(panel);
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();

				login();*/
				
				frame.dispose(); 
				controller = new AuthController(); 
				controller.login();
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
		
		frame.repaint();
		frame.revalidate();
		
	}
	
	public void login() {
		
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(180, 188, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Iniciar sesión");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(69, 42, 210, 44);
		panel.add(lblNewLabel);

		JTextField username = new JTextField();
		username.setBounds(81, 126, 210, 44);
		panel.add(username);
		username.setColumns(10);

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
		
		JTextField password = new JTextField();
		password.setColumns(10);
		password.setBounds(81, 229, 210, 44);
		panel.add(password);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { 
				
				
				functions.login(username.getText(), password.getText());
			}
			
		});

		JButton btnNewButton_1 = new JButton("Crear cuenta");
		btnNewButton_1.setBounds(81, 390, 210, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				/*frame.getContentPane().remove(panel);
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();

				register();*/
				

				frame.dispose();
				
				controller = new AuthController();
				
				controller.registro();
			}
		});
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setForeground(new Color(234, 252, 255));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(84, 213, 200, 16);
		panel.add(lblNewLabel_1_1);

		
		
		frame.repaint();
		frame.revalidate();
		
	}
}
