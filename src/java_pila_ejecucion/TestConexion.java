package java_pila_ejecucion;

public class TestConexion {
	
	public static void main(String[] args) {
		Conexion con = new Conexion();
		try {
			con.leerDatos();
			
		}
		catch (IllegalStateException ex){
			System.out.println("recibiendo exception");
			ex.printStackTrace();
			con.cerrar();
		}
		
	}

}
