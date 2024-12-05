package interfaces_2;

public class Main {
	public static void main(String[] args) {
		
		// Función anonima
		SinParametrosEntrada spe = () -> System.out.println("Esto no tiene parametros");
		spe.accion();
		
		// Funcion anonima
		spe = new SinParametrosEntrada() {
			
			@Override
			public void accion() {
				System.out.println("Esto no tiene parametros (Clase Anonima)");
				
			}
		};
		spe.accion();
	}

}
