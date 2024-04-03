import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tarjeta extends JButton{
	
	String imagen;
	int estado;
	int identificador;
	
	public Tarjeta(int ide) {
		
		this.identificador = ide;
		this.estado = 0;
		this.setIcon(new ImageIcon(getClass().getResource("back.jpg")));
		
	}
	
	public void girar() {
		
		if( this.estado == 0 ) {
			System.out.println(identificador+".png");
			this.setIcon(new ImageIcon(getClass().getResource(identificador+".png")));
			this.estado  = 1;
		}else if(this.estado==1){ 
			 
			this.setIcon(new ImageIcon(getClass().getResource("back.jpg")));
			this.estado  = 0;
		}
		
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getEdentificador() {
		return identificador;
	}

	public void setEdentificador(int edentificador) {
		this.identificador = edentificador;
	}

}
