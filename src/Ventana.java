import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Ventana extends JFrame implements MouseListener, KeyListener{
	
	Random rand = new Random();
	JPanel panel;
	
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
		
		this.addMouseListener(this);
		this.addKeyListener(this);
	}
	
	public void loadComponents() {
		
		
		//this.login();
		
		//this.registro();
		
		//this.admin();
		
		//this.calculadora();
		
		this.botones();
	}
	
	
	public void calculadora() {
		
		this.setSize(500,650);
		
		JPanel calculadora = new JPanel();
		calculadora.setSize(this.getWidth(), this.getHeight());
		calculadora.setLocation(0,0);
		calculadora.setLayout(new BorderLayout());
		calculadora.setBackground(Color.black);
		
		JLabel input = new JLabel("20.00",4);
		input.setOpaque(true);
		input.setBackground(Color.white);
		input.setFont(new Font("SignPainter", Font.BOLD, 40));
		calculadora.add(input, BorderLayout.NORTH);
		
		JPanel botones = new JPanel();
		botones.setLayout(new GridLayout(4,3));
		botones.setBackground(Color.red);
		calculadora.add(botones,BorderLayout.CENTER );
		
		String btn_texts[]= {"9","8","7","6","5","4","3","2","1","0","."};
		
		for (int i = 0; i < btn_texts.length; i++) {  
			botones.add(new JButton(btn_texts[i]));  
		}
		
		JPanel actions = new JPanel();
		actions.setLayout(new GridLayout(6,1));
		actions.setBackground(Color.green);
		
		actions.setBorder( BorderFactory.createEmptyBorder(0,20,0,20) );
		
		calculadora.add(actions,BorderLayout.EAST );
		
		String actions_texts[]= {"+","-","*","/","=","CE"};
		
		for (int i = 0; i < actions_texts.length; i++) {  
			actions.add(new JButton(actions_texts[i]));  
		} 
		
		this.add(calculadora);
		
	}
	
	public void botones() {
		
		this.setSize(500,650);
		
		panel = new JPanel();
		panel.setSize(this.getWidth(), this.getHeight());
		panel.setLocation(0,0);
		panel.setLayout(null);
		panel.setBackground(Color.gray);
		
		
		JButton action_btn = new JButton("CLICK ME");
		action_btn.setBounds(150, 540, 220, 60);
		action_btn.setFont(new Font("SignPainter", Font.BOLD, 30) ); 
		action_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int x = rand.nextInt(400); 
				int y = rand.nextInt(550);  
				
				int w = rand.nextInt(80); 
				int h = rand.nextInt(80); 
				
				int nextInt = rand.nextInt(0xffffff + 1);  
		        String colorCode = String.format("#%06x", nextInt);
				
				JButton tmp = new JButton("H");
				tmp.setLocation(x, y);
				tmp.setSize(w, h);
				tmp.setOpaque(true);
				tmp.setBackground(Color.decode(colorCode));
				panel.add(tmp);
				
				repaint();
				revalidate();
			}
		});
		
		panel.add(action_btn);
		
		this.add(panel);
	}
	
	public void login()
	{
		//mi panel
		JPanel login = new JPanel();
		login.setSize(this.getWidth()/2, this.getHeight());
		login.setLocation(0,0);
		login.setLayout(null);
		login.setBackground(Color.decode("#6C6867"));
		
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
		user_tag.setLocation(100, 70);
		user_tag.setSize(180, 30);
		user_tag.setOpaque(true); 
		login.add(user_tag);
		
		JTextField user_field = new JTextField();
		user_field.setBounds(100, 120, 180, 30);
		login.add(user_field);
		
		JLabel pwd_tag = new JLabel("Contraseña: ");
		pwd_tag.setFont(new Font("Agency FB", Font.BOLD, 15));
		pwd_tag.setBackground(Color.white);
		pwd_tag.setLocation(100, 170);
		pwd_tag.setSize(180, 30);
		pwd_tag.setOpaque(true); 
		login.add(pwd_tag);
		
		JPasswordField pwd_field = new JPasswordField();
		pwd_field.setBounds(100, 220, 180, 30);
		pwd_field.setBackground(Color.gray);
		pwd_field.setOpaque(true);
		login.add(pwd_field);
		
		JButton login_btn = new JButton("ACCEDER");
		login_btn.setBounds(100, 270, 180, 30);
		
		login_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("hola");
				
				if(user_field.getText().length()<=0) {
					
					user_field.setBorder(new LineBorder(Color.RED, 4));
				}else {
					user_field.setBorder(new LineBorder(Color.GREEN, 4));
				}
				
				
				String pwd = new String(pwd_field.getPassword()); 
				
				System.out.println(pwd);
				if(pwd.length() <=0){
					pwd_field.setBorder(new LineBorder(Color.RED, 4));
				}else {
					pwd_field.setBorder(new LineBorder(Color.GREEN, 4));
				}
				
				System.out.println(user_field.getText());
				System.out.println(pwd_field.getPassword());
			}
		});
		
		login.add(login_btn);
		
		JLabel img = new JLabel(""); 
		img.setIcon(new ImageIcon(getClass().getResource("tambien.png")));
		img.setBounds(10, 300, 256, 256);
		img.setOpaque(true);
		img.setBackground(Color.white);
		login.add(img);
		
		this.add(login);
		this.repaint();
		
		login.repaint();
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
		
		register_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hola");
				
				if( name_field.getText().length()<=0 ) {
					
					name_field.setBorder(new LineBorder(Color.RED, 4));
				}else {
					name_field.setBorder(new LineBorder(Color.GREEN, 4));
				}
				
				if(type.isSelected() == false) {
					
					type.setBorderPainted(true);
					type.setBorder(new LineBorder(Color.RED, 4));
					
				}else {
					type.setBorderPainted(true);
					type.setBorder(new LineBorder(Color.GREEN, 4));
				}
				
				if( bio.getText().length()<=0 ) {
					
					bio.setBorder(new LineBorder(Color.RED, 4));
				}else {
					bio.setBorder(new LineBorder(Color.GREEN, 4));
				}
			}
			
		});
		
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

	public void admin() {
		
		JPanel admin_panel = new JPanel();
		admin_panel.setSize(this.getWidth(), this.getHeight());
		admin_panel.setLocation(0,0);
		admin_panel.setLayout(null);
		admin_panel.setBackground(Color.pink);
		
		JLabel users_tag = new JLabel("Usuarios",0);
		users_tag.setBounds(350, 20, 300, 80);
		users_tag.setFont(new Font("SignPainter", Font.BOLD, 80));
		admin_panel.add(users_tag);
		
		//widget
		
		JLabel widget_title = new JLabel("Usuarios",0);
		widget_title.setBounds(40, 120, 300, 40);
		widget_title.setFont(new Font("SignPainter", Font.BOLD, 40));
		widget_title.setForeground(Color.white);
		admin_panel.add(widget_title);
		
		JLabel widget_text = new JLabel("80",0);
		widget_text.setBounds(40, 160, 300, 40);
		widget_text.setFont(new Font("SignPainter", Font.BOLD, 30));
		widget_text.setForeground(Color.white);
		admin_panel.add(widget_text);
		
		JLabel widget = new JLabel("");
		widget.setBounds(40, 120, 300, 80);
		widget.setOpaque(true);
		widget.setBackground(Color.black);
		admin_panel.add(widget); 
		
		JButton add_user = new JButton("Añadir");
		add_user.setBounds(880, 200, 80, 40);
		admin_panel.add(add_user);
		
		JButton download_user = new JButton("Descargar");
		download_user.setBounds(790, 200, 80, 40);
		admin_panel.add(download_user);
		
		
		String titles[] = {"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"};
		String data[][] = {
				
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"},
				{"No. Control","Nombre","Apellidos","Correo electrónico","Semestre","Carrera","Acciones"}
				
		};
		
		JTable table = new JTable(data,titles);
		//table.setBounds(40, 260, 920, 380);
		
		JScrollPane table_scroll = new JScrollPane(table);
		table_scroll.setBounds(40, 260, 920, 380);
		
		admin_panel.add(table_scroll);
		
		/*JLabel table = new JLabel();
		table.setBounds(40, 260, 920, 380);
		table.setOpaque(true);
		table.setBackground(Color.black);
		admin_panel.add(table);*/
		
		
		this.add(admin_panel);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub 
		
		int x = e.getX(); 
		int y = e.getY();  
		
		int w = rand.nextInt(80); 
		int h = rand.nextInt(80); 
		
		int nextInt = rand.nextInt(0xffffff + 1);  
        String colorCode = String.format("#%06x", nextInt);
		
		JButton tmp = new JButton("H");
		tmp.setLocation(x, y);
		tmp.setSize(w, h);
		tmp.setOpaque(true);
		tmp.setBackground(Color.decode(colorCode));
		
		tmp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("hola");
				
				JButton link = (JButton) e.getSource();
				
				link.setBackground(Color.red);
				
				panel.remove(link);
				
				repaint();
				revalidate();
			}});
		
		panel.add(tmp);
		
		repaint();
		revalidate();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		int nextInt = rand.nextInt(0xffffff + 1);  
        String colorCode = String.format("#%06x", nextInt);
        
        panel.setBackground(Color.decode(colorCode));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println( e.getKeyCode() );
		
		if(e.getKeyCode() == 8) {
			
			panel.removeAll();
			repaint();
			revalidate();
		}
		
		if(e.getKeyCode()==87) {
			
			Component arreglo[] = panel.getComponents();
			
			for (int i = 0; i < arreglo.length; i++) { 
				
				if(arreglo[i].getClass().toString().equals("class javax.swing.JButton")) {
					
					JButton link = (JButton) arreglo[i];
					
					link.setSize(link.getWidth()+5, link.getHeight()+5);
					repaint();
					revalidate();
				}
				
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawArc(100, 100, 100, 200, 45, 180);
		
		g2d.setColor(Color.red);
		
		g2d.drawLine(0, 0, 500, 500);
		
		g2d.drawOval(150, 200, 80, 80);
		
		g2d.setColor(Color.blue);
		
		int xS [] = {225,150,300,225};
		int yS [] = {50, 150,150,50};
		g2d.drawPolyline(xS, yS, 4);
		
		
		g2d.drawRect(300, 300, 200, 150);
		
		g2d.drawRoundRect(350, 350, 200, 200, 15, 15);
		
		g2d.setColor(Color.green);
		g2d.setFont(new Font("SignPainter", Font.BOLD, 80));
		g2d.drawString("Hola", 400, 140);
		
		g2d.fillArc(500, 100, 200, 200, 0, 90);
		
		g2d.fillOval(180, 230, 80, 80);
		
		int xS2 [] = {255,180,330,255};
		int yS2 [] = {80, 180,180,80};
		
		g2d.fillPolygon(xS2, yS2, 4);
		
		g2d.setColor(Color.black);
		g2d.fillRect(600, 300, 300, 100);
		
		g2d.clearRect(650, 350, 100, 50);
		 
		try { 
			
			BufferedImage imagen = ImageIO.read(new File("src/tambien.png"));
			g2d.drawImage(imagen, 200, 200, null);
			
		
		} catch (IOException e) { 
			e.printStackTrace();
		}
		
	}
	*/


	 

	 
}







