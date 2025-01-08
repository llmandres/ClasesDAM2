package excepcionesActividad;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Main {

	public static void main(String[] args) {
	boolean flag = false;

	System.out.println("EJERCICIO 1.------------------------");
	// concatenarCadenas(null, null); -> Esto daría error
		try {
			System.out.println(concatenarCadenas("Hola ", "que tal"));
			flag = true;
		} catch (Exception e) {
			System.out.println("Error, NULL introducido");
		}
		try {

			System.out.println(concatenarCadenas(null, "que tal"));
			flag = true;
		} catch (Exception e) {
			System.out.println("Error, NULL introducido");
		}
		System.out.println("EJERCICIO 2.----------------------");
		concatenarCadenasUnchecked(null, null);
		concatenarCadenasUnchecked("Hola ", " adios");

	}
	// PRIMER METODO
	public static String concatenarCadenas (String a , String b) throws Exception{
		String cadena = "";
			cadena = a.concat(b);

		return cadena;
	}
	public static String concatenarCadenasUnchecked (String a , String b) throws RuntimeException{
		if(a == null || b == null) {
			throw new NullPointerException("valores nulos");
		}
		String cadena = "";
		cadena = a.concat(b);

		return cadena;
}
}
