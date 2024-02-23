import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ventana extends JFrame{

	public Ventana() {
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,750);
		this.setLocationRelativeTo(null);
		//this.setLocation(100, 100);

		this.setTitle("Mi ventanita");
		this.setResizable(true); 
		this.setMinimumSize(new Dimension(200,200));
		
		//quita el molde 
		this.setLayout(null);
		
		this.loadComponents();
	}
	
	public void loadComponents() {
		
		
		this.login();
		
		this.registro();
		
	}
	
	public void login()
	{
		//mi panel
		JPanel login = new JPanel();
		login.setSize(this.getWidth()/2, this.getHeight());
		login.setLocation(0,0);
		login.setLayout(null);
		login.setBackground(Color.black);
		
		JLabel title = new JLabel("Bienvenido al sistema",SwingConstants.CENTER);
		title.setFont(new Font("Agency FB", Font.BOLD, 20));
		title.setBackground(Color.white);
		title.setLocation(150, 10);
		title.setSize(220, 40);
		title.setOpaque(true); 
		login.add(title);
		
		JLabel user_tag = new JLabel("Correo electrónico: ");
		user_tag.setFont(new Font("Agency FB", Font.BOLD, 15));
		user_tag.setBackground(Color.white);
		user_tag.setLocation(10, 70);
		user_tag.setSize(180, 30);
		user_tag.setOpaque(true); 
		login.add(user_tag);
		
		JTextField user_field = new JTextField();
		user_field.setBounds(10, 120, 180, 30);
		this.add(user_field);
		
		JLabel pwd_tag = new JLabel("Contraseña: ");
		pwd_tag.setFont(new Font("Agency FB", Font.BOLD, 15));
		pwd_tag.setBackground(Color.white);
		pwd_tag.setLocation(10, 170);
		pwd_tag.setSize(180, 30);
		pwd_tag.setOpaque(true); 
		login.add(pwd_tag);
		
		JPasswordField pwd_field = new JPasswordField();
		pwd_field.setBounds(10, 220, 180, 30);
		pwd_field.setBackground(Color.red);
		pwd_field.setOpaque(true);
		this.add(pwd_field);
		
		JButton login_btn = new JButton("ACCEDER");
		login_btn.setBounds(10, 270, 180, 30);
		this.add(login_btn);
		
		this.add(login);
		this.repaint();
	}
	
	public void registro()
	{
		JPanel registro = new JPanel();
		registro.setSize(this.getWidth()/2, this.getHeight());
		registro.setLocation(this.getWidth()/2,0);
		registro.setLayout(null);
		registro.setBackground(Color.decode("#EA8AEE"));
		
		JLabel titleR = new JLabel("Registro",SwingConstants.CENTER);
		titleR.setFont(new Font("SignPainter", Font.BOLD, 60));
		titleR.setBackground(Color.white);
		titleR.setLocation(150, 10);
		titleR.setSize(220, 60);
		titleR.setOpaque(false); 
		registro.add(titleR);
		
		JLabel name_tag = new JLabel("Nombre completo: ");
		name_tag.setFont(new Font("SignPainter", Font.BOLD, 30)); 
		name_tag.setLocation(10, 70);
		name_tag.setSize(180, 30); 
		registro.add(name_tag);
		
		JTextField name_field = new JTextField();
		name_field.setBounds(9, 95, 350, 35);
		name_field.setFont(new Font("SignPainter", Font.BOLD, 30));
		registro.add(name_field);
		
		JLabel likes_tag = new JLabel("Marque las casillas: ");
		likes_tag.setFont(new Font("SignPainter", Font.BOLD, 30)); 
		likes_tag.setBounds(10, 140, 350, 40);
		registro.add(likes_tag);
		
		JCheckBox gusto1 = new JCheckBox("Chocolate");
		gusto1.setBounds(10, 180, 110, 35);
		gusto1.setOpaque(false);
		gusto1.setBackground(Color.green);
		registro.add(gusto1);
		
		JCheckBox gusto2 = new JCheckBox("Pizza");
		gusto2.setBounds(120, 180, 120, 35);
		gusto2.setOpaque(false);
		gusto2.setBackground(Color.red);
		registro.add(gusto2);
		
		JLabel type_tag = new JLabel("Selecciona una opción: ");
		type_tag.setFont(new Font("SignPainter", Font.BOLD, 30)); 
		type_tag.setBounds(10, 220, 350, 40);
		registro.add(type_tag);
		
		JRadioButton type = new JRadioButton("Al sartén");
		type.setBounds(10, 250, 120, 35);
		registro.add(type);
		
		JRadioButton type2 = new JRadioButton("Tradicional");
		type2.setBounds(130, 250, 350, 35);
		registro.add(type2);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(type);
		grupo.add(type2); 
		
		JLabel bio_tag = new JLabel("Descríbete: ");
		bio_tag.setFont(new Font("SignPainter", Font.BOLD, 30)); 
		bio_tag.setBounds(10, 290, 350, 40);
		registro.add(bio_tag);
		
		JTextArea bio = new JTextArea(10,10);
		bio.setLocation(10, 330);
		bio.setSize(350, 100);
		bio.setFont(new Font("SignPainter", Font.BOLD, 30));
		registro.add(bio); 
		
		
		JLabel location_tag = new JLabel("Donde vives: ");
		location_tag.setFont(new Font("SignPainter", Font.BOLD, 30)); 
		location_tag.setBounds(10, 440, 350, 40);
		registro.add(location_tag);
		
		String colonias[] = {"Diana Laura","Camino Real","Pedregal","La 8","Panteón"};
		
		JComboBox location_box = new JComboBox(colonias);
		location_box.setBounds(10, 480, 350, 40); 
		registro.add(location_box);
		
		JButton register_btn = new JButton("GUARDAR");
		register_btn.setBounds(100, 540, 220, 60);
		register_btn.setFont(new Font("SignPainter", Font.BOLD, 30) );
		registro.add(register_btn);
		
		JMenuBar barra = new JMenuBar(); 
		JMenu lista1 = new JMenu("Archivo");
		
		JMenuItem option1 = new JMenuItem("Abrir");
		JMenuItem option2 = new JMenuItem("Nuevo");
		
		barra.add(lista1);
		lista1.add(option1);
		lista1.add(option2);
		
		this.setJMenuBar(barra);
		
		this.add(registro);
		this.repaint();
	}
}
