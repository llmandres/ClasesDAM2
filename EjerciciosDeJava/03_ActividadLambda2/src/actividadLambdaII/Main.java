package actividadLambdaII;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		
		// 1. Una función lambda que devuelva el número de letras que tiene una frase pasada por parámetro
		
		Function<String, Integer> contadorLetras = (v) -> {
			
			v.toCharArray();
			return v.length();
		};
		System.out.println(contadorLetras.apply("Hola"));
		
		// 2. Una función lambda que dados 2 números devuelva la distancia entre ambos
		
		BiFunction<Integer, Integer, Integer> distanciaEntreNumeros = (op1,op2) -> {
			int distancia = 0;
			if(op1>op2) {
				distancia = op1-op2;
			}else if(op1<op2) {
				distancia = op2-op1;
			}else {
				distancia = 0;
			}
			return distancia;
		};
		System.out.println(distanciaEntreNumeros.apply(20, 109));
		
		// 3. Una función lambda que dado una cadena y un número, devuelva una subcadena 
		// desde el principio hasta el número del caracter pasado por parámetro
		
		BiFunction<String, Integer, String> devolverCadenaPartida  = (v,numero) -> {
			
			String cadena = "";
			cadena = v.substring(0,numero);
			return cadena;
		};
		System.out.println(devolverCadenaPartida.apply("Holaaaaa", 5));
		
		// 4. Una función lambda que devuelva true en caso de que una fase introducida por parámetro 
		// contiene la cádena "pepe"
		
		Function<String, Boolean> devuelveTrueSiPepe = (v) -> {
			boolean flag = false;
			v.toLowerCase();	
			if (v.contains("pepe")) {
				flag= true;
			}
			return flag;
		};
		System.out.println(devuelveTrueSiPepe.apply("pePe"));
		
		// 5. Una función lambda que imprima por pantalla un array de números pasado por parámetro.
		Consumer <List<Integer>> imprimeArrayDeNumeros = (s) -> {
			System.out.println("Recorriendo Array");
			s.forEach((t -> System.out.println(t)));
			
		};
		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(1);
		numeros.add(2);
		imprimeArrayDeNumeros.accept(numeros);
		
		// 6. Una función lambda que reciba 3 números y devuelva el mayor de los tres.
		
		TriFunction<Integer, Integer, Integer, Integer> devuelveNumeroMasGrande = (n1,n2,n3) -> {
			int numeroAlto = 0;
			if(n1 >= n2 && n1 >=n3) {
				numeroAlto = n1;
			}else if (n2 >= n1 && n2>=n3) {
				numeroAlto = n2;
			}else if(n3>=n1 && n3>=n2) {
				numeroAlto =  n3;
			}
			return numeroAlto;
		};
		System.out.println("El numero más alto es  " + devuelveNumeroMasGrande.calcular(10, 100, 25));
	}

}
