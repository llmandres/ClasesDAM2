package actividadLambdaImprimible;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		
		// Imprimir en fichero
		Imprimible imprimir = (cadena) -> {
			try {
				PrintWriter pw = new PrintWriter("fichero.txt");
				pw.println(cadena);//LLenamos el buffer con la información
				pw.flush();//Pasamos la información del buffer al fichero
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		};
		
		imprimir.imprimir("Hola");
		
		//Imprimir en Impresora
		
		imprimir = (cadena) -> {
			String IP = "192.168.56.13";//Supongamos que la impresora esta aquí
			//Simulamos la impresion por impresora
			System.out.println("Imprimiendo por impresora: " + cadena);
		};
		imprimir.imprimir("Impresion en Impresora");
		
		// Imprimir en Pantalla
		
		imprimir = (cadena) -> {
			System.out.println(cadena);	
		};
		imprimir.imprimir("Impresion por pantalla");

	}

}
