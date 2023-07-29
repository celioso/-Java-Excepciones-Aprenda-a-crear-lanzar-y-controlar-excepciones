package java_pila_ejecucion;

public class Flujo {
	
	 public static void main(String[] args) {
		    System.out.println("Inicio main");
		    try {
				metodo1();
			} catch (MyException e) {
				e.printStackTrace();
			}
		    System.out.println("Fin main");
		  }
		  public static void metodo1() throws MyException {
		    System.out.println("Inicio de metodo1");

		    metodo2();
		    
		    System.out.println("Fin de metodo1");
		  }
		  public static void metodo2() throws MyException {
		    System.out.println("Inicio de metodo2");
		  
		    throw new MyException("Mi excepcion fue lanzada");
			
		  }
}
