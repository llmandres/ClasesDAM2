package actividadLambdaImpresion;

public class Main {

	public static void main(String[] args) {
		IDevolucion id = (cadena) -> {
			return "Hola " + cadena;
		};
		System.out.println(id.devolver("que tal"));

		id = (cadena) -> {
			String noEspacios = cadena.trim();
			return noEspacios;
		};
		System.out.println(id.devolver("        Hola          "));
	}

}
