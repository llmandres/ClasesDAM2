package interfacesDeJava;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		
		// Funciones lambda que vienen en Java
		// Esta en el documento de los apuntes 31_Java8
		
		// Funcion Supplier (No tiene parametros de entrada pero si de salida)
		// Devuelve el tipo de dato que le pongamos.
		Supplier<Integer> numeroAleatorio = () -> {
			Random rd = new Random();
			int numero = rd.nextInt(1,100);
			return numero;
		};
		System.out.println(numeroAleatorio.get());
		
		numeroAleatorio = new Supplier<Integer>() {
			
			@Override
			public Integer get() {
				Random rd = new Random();
				int numero = rd.nextInt(1,100);
				return numero;
			}
		};
		
		// Funcion Consumer tiene parametro de entrada pero no devuelve nada
		// Es decir es void
		
		Consumer<String> log = (v) -> {
			Date date = new Date();
			System.out.println("**** " + date + " - " + v);
		};
		log.accept("NullPointerException");
		log.accept("Datos recibidos");
		
		// Funcion function tiene parametro de entrada y devulve algo tambien
		// Le decimos al crear la interfaz Function que tipo de dato queremos que sean
		
		Function<Double, Double> raizCuadrada = (v) -> {
			double raiz = Math.sqrt(v);
			return raiz;
		};
		System.out.println(raizCuadrada.apply(9.0));
		
		List<Integer> listaEnteros = new ArrayList<Integer>();
		listaEnteros.add(1);
		listaEnteros.add(2);
		listaEnteros.add(3);
		
		// Los arrays se pueden recorrer:
		// 1. Un for clasico con las i etc
		// 2. Un for each
		for (Integer i : listaEnteros) {
			System.out.println(i);
		}
		// 3. Un for each LAMBDA
		
		// FOR EACH CON CLASE ANONIMA
		System.out.println("----------FOR EACH CLASE ANONIMA----------");
		Consumer<Integer> recorrer = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				System.out.println(t);
				
			}
		};
		listaEnteros.forEach(recorrer);
		
		System.out.println("----------FOR EACH LAMBDA con variable----------");
		Consumer<Integer> recorrerLambda = (v) -> {
			System.out.println(v);
		};
		listaEnteros.forEach(recorrerLambda);
		
		// Lo que hace esto es recorrer el array listaEnteros creando una funcion lambda
		// directamente, realmente lo que pasa es lo de arriba, una funcion lambda que
		// viene de la interfaz Consumer, explicado arriba
		System.out.println("----------FOR EACH LAMBDA ----------");
		listaEnteros.forEach((v) -> System.out.println(v));
		
		// Si solo tiene un parametro de entrada puedes quitarle los parentesis que rodean
		// los parametros de entrada 
		listaEnteros.forEach(v -> System.out.println(v));
		

	}

}
