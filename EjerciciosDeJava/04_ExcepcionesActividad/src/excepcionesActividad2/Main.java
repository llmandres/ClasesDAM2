package excepcionesActividad2;

public class Main {

	public static void main(String[] args) {

		System.out.println("EJERCICIO 3 -------------");
		// Ejercicio 3
		Persona p = new Persona();
		// Ejemplo con positivo
		try {
			p.setEdad(10);
		} catch (EdadNoPermitida e) {
			e.printStackTrace();
		}
		System.out.println(p.getEdad());
		// Ejemplo con negativo
		System.out.println("Ejemplo MAL");
		try {
			p.setEdad(-2);
		} catch (EdadNoPermitida e) {
			e.printStackTrace();
		}
		
		// EJERCICIO 4

		System.out.println("EJERCICIO 4---------------");
		Persona p1 = new Persona(20, "Juan");
		
		// EJEMPLOS NOMBRE VACIO Y NULL
		Persona p2 = new Persona(30, "");
		Persona p3 = new Persona(40, null);
	}

}
