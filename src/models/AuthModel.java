package models;

public class AuthModel {
	
	//base de datos
		
	public AuthModel() {
		
	}
	
	
	public void login(String username, String password) {
		
		if(username.equals("admin") && password.equals("1234")) {
			
			System.out.println( "Bienvenido" );
		}else
			System.err.println(" Error de acceso");
		
	}
}
